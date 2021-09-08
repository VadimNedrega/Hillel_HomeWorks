package vadim_nedrega.HW14_Refactoring.datastore;

import com.google.gson.Gson;
import vadim_nedrega.HW14_Refactoring.common.TypeUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileDataStore<T> implements DataStore<T> {
    private final String dirPath;
    private final Class<? extends T> clazz;
    private final List<Field> fieldList = new ArrayList<>();
    private final Constructor<? extends T> defaultConstructor;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private String data;


    public FileDataStore(String dirPath, Class<? extends T> clazz) throws DataStoreException {
        Checking<T> checking = new Checking<T>(dirPath, clazz);
        this.dirPath = checking.checkIfDirectory(dirPath);
        this.clazz = checking.checkClass(clazz);

        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        for (Field field : fieldList) {
            field.setAccessible(true);
        }
        try {
            defaultConstructor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new DataStoreException("Class doesn't have default constructor", e);
        }
    }

    @Override
    public void save(List<T> objList) throws DataStoreException {
        final Gson GSON = new Gson();
        List<String> objectStringList = new ArrayList<>();
        String result;
        for (T t : objList) {
            objectStringList.add(GSON.toJson(t));
        }
        if (objList.size() == 0) throw new DataStoreException("There is no object to save");
        if (objList.size() == 1) result = "[" + objectStringList + "]";
        result = "[" + String.join(",", objectStringList) + "]";
        try {
            outputStream = new FileOutputStream(dirPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<T> load() throws DataStoreException {
        List<T> result = new ArrayList<>();
        data = loadDataFromFile();
        String[] objStringArr = getObjString(data);

        for (String objString : objStringArr) {
            T newObj = createNewObject();
            String[] fieldKVArray = objString.split(",");
            for (String fieldKV : fieldKVArray) {
                String[] kv = fieldKV.split(":");
                String key = kv[0].substring(1, kv[0].length() - 1);
                String value = getValue(kv);
                Field objField = getObjField(fieldKVArray, key);
                Class<?> type = objField.getType();
                if (type.isPrimitive() || type == String.class) {
                    Method valueOf = getValueOfMethod(objField);
                    Object invoke = getInvoke(valueOf, type, value);
                    try {
                        Class<?> appropriateType = getAppropriateType(type, invoke);
                        objField.set(newObj, invoke);
                    } catch (IllegalAccessException e) {
                        throw new DataStoreException("Problems with wrapping types");
                    }
                } else {
                    throw new DataStoreException("Type of fields is not primitive or String");
                }
            }
            result.add(newObj);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }

    private String loadDataFromFile() {
        byte[] byteArr = null;
        data = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(dirPath));
            byteArr = inputStream.readAllBytes();
            data = new String(byteArr, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String[] getObjString(String str) {
        str = loadDataFromFile();
        str = str.replace("[", "");
        str = str.replace("]", "");
        String[] objString = str.split("},\\{");
        for (int i = 0; i < objString.length; i++) {
            objString[i] = objString[i].replace("{", "");
            objString[i] = objString[i].replace("}", "");
        }
        return objString;
    }

    private T createNewObject() throws DataStoreException {
        String[] objectString = getObjString(data);
        T newObj = null;
        for (int i = 0; i < objectString.length; i++) {
            try {
                newObj = defaultConstructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new DataStoreException("New Object wasn't created", e);
            }
        }
        return newObj;
    }

    private Field getObjField(String[] arr, String key) throws DataStoreException {
        Field objField = null;
        for (Field field : fieldList) {
            if (Objects.equals(field.getName(), key)) {
                objField = field;
                break;
            }
        }
        if (objField == null) {
            throw new DataStoreException("");
        }
        return objField;
    }

    private Method getValueOfMethod(Field objField) throws DataStoreException {
        Class<?> type = objField.getType();
        Method valueOf;
        try {
            Class<?> inputType = String.class;
            if (type == String.class) {
                inputType = Object.class;
            }
            Class<?> newType = type.isPrimitive() ? TypeUtils.wrap(type) : type;
            valueOf = newType.getDeclaredMethod("valueOf", inputType);
        } catch (NoSuchMethodException e) {
            throw new DataStoreException("Method is not detected");
        }
        return valueOf;
    }

    private Object getInvoke(Method valueOf, Class<?> type, String value) throws DataStoreException {
        Object invoke;
        try {
            invoke = valueOf.invoke(type, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new DataStoreException("The is no method to invoke");
        }
        return invoke;
    }

    private Class<?> getAppropriateType(Class<?> type, Object invoke) {
        if (type.isPrimitive()) {
            return TypeUtils.unwrap(invoke.getClass());
        } else {
            return TypeUtils.wrap(invoke.getClass());
        }
    }
    private String getValue (String [] strings){
        if (!strings[1].contains("\"")){
           return strings[1];
        } else return strings[1].substring(1, strings[1].length() - 1);
    }
}
