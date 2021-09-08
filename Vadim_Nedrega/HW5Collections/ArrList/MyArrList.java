package vadim_nedrega.HW5Collections.ArrList;

import java.util.*;

public class MyArrList<T> {

    public static class ArrList<T> implements List<T> {
        private int capacity;
        private int size;
        private T[] array;

        public ArrList() {
            this(5);
        }

        @SuppressWarnings("unchecked")
        public ArrList(int capacity) {
            this.capacity = capacity;
            this.array = (T[]) new Object[capacity];
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public boolean contains(Object o) {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(o)) return true;
            }
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    for (int i = 0; i < size; i++) {
                        if ((i + 1) > size) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override
                public T next() {
                    T target = array[0];
                    for (int i = 0; i < size; i++) {
                        if ((i + 1) < size) {
                            target = array[i + 1];
                        }
                    }
                    return target;
                }
            };
        }

        @Override
        @SuppressWarnings("unchecked")
        public Object[] toArray() {
            T[] result = (T[]) new Object[size];
            System.arraycopy(array, 0, result, 0, size);
            return result;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean add(T o) {
            if (!incrementCapasityAndGetArr()) {
//                T[] temp = returnArr();
//                System.arraycopy(array, 0, temp, 0, array.length);
//                this.array = (T[]) new Object[increaseCapasity()];
//                System.arraycopy(temp, 0, array, 0, temp.length);
                T[] temp = (T[]) new Object[increaseCapasity()];
                System.arraycopy(array, 0, temp, 0, array.length);
                array = temp;
            }
            array[size++] = o;

            return true;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(Object o) {
            T target;
            T[] newArr = (T[]) new Object[size() - 1];
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    target = array[i];
                    if (target == array[0]) {
                        try {
                            System.arraycopy(array, 1, newArr, 0, newArr.length);
                        } catch (UnsupportedOperationException e) {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        try {
                            System.arraycopy(array, 0, newArr, 0, i - 1);
                            System.arraycopy(array, i + 1, newArr, i, newArr.length);
                        } catch (UnsupportedOperationException e) {
                            throw new UnsupportedOperationException();
                        }
                    }
                }
            }
            size--;
            newArr = array;
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            if (c.size() + size < capacity) {
                for (T data : c) {
                    for (int i = 0; i < c.size(); i++) {
                        simpleAdd(data);
                    }
                    break;
                }
            } else {
                array = incrementCapasityAndReturnArr();
                for (T data : c) {
                    for (int i = 0; i < c.size(); i++) {
                        simpleAdd(data);
                    }
                    break;
                }
            }

            return true;
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> c) {
            T[] temp = array;
            int tepmSize = size;
            if (c.size() + size < capacity) {
                for (T data : c) {
                    for (int i = 0; i < c.size(); i++) {
                        simpleAddByIndex(index++, data);
                    }
                    size = size + c.size();
                    break;
                }
                try {
                    System.arraycopy(temp, index, array, index + c.size(), tepmSize - index);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            } else {
                array = incrementCapasityAndReturnArr();
                for (T data : c) {
                    for (int i = 0; i < c.size(); i++) {
                        simpleAddByIndex(index++, data);
                    }
                    size = size + c.size();
                    break;
                }
                try {
                    System.arraycopy(temp, index, array, index + c.size(), tepmSize - index);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }

            return true;
        }

        @Override
        public void clear() {
            size = 0;
        }

        @Override
        public T get(int index) {
            if (index < 0 && index > size) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
        }

        @Override
        public T set(int index, T element) {
            if (index < 0 && index > size) {
                throw new IndexOutOfBoundsException();
            }
            T target = get(index);
            target = element;
            return element;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void add(int index, T element) {
            T[] newArr = (T[]) new Object[capacity + 1];
            if (index < size()) {
                if (index == 0) {
                    try {
                        newArr[0] = element;
                        System.arraycopy(array, 0, newArr, 1, array.length);
                        array = newArr;
                    } catch (UnsupportedOperationException e) {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    try {
                        newArr[index] = element;
                        System.arraycopy(array, 0, newArr, 0, index);
                        System.arraycopy(array, index, newArr, index + 1, size - index);
                        array = newArr;
                    } catch (UnsupportedOperationException e) {
                        throw new UnsupportedOperationException();
                    }
                }
            } else throw new IndexOutOfBoundsException();
            size++;
//            newArr = array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T remove(int index) {
            T[] newArr = (T[]) new Object[size() - 1];
            if (index < size()) {
                if (array[0] == array[index]) {
                    try {
                        System.arraycopy(array, 1, newArr, 0, size() - 1);
                    } catch (UnsupportedOperationException e) {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    try {
                        System.arraycopy(array, 0, newArr, 0, index - 1);
                        System.arraycopy(array, index + 1, newArr, index, newArr.length);
                    } catch (UnsupportedOperationException e) {
                        throw new UnsupportedOperationException();
                    }
                }
            } else throw new IndexOutOfBoundsException();
            size--;
            newArr = array;
            return array[index];
        }

        @Override
        public int indexOf(Object o) {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
            return -100;
        }

        @Override
        public int lastIndexOf(Object o) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
            return -100;
        }

        @Override
        public ListIterator<T> listIterator() {
            return new Arrterator() {
            };
        }

        @Override
        public ListIterator<T> listIterator(int index) {
            return new Arrterator(index);
        }

        @Override
        public List<T> subList(int fromIndex, int toIndex) {
            ArrList<T> sublist = new ArrList<>();
            if (fromIndex == toIndex) {
                return new ArrayList<>();
            }
            if (fromIndex < toIndex) {
                throw new IllegalArgumentException();
            }
            int result = toIndex - fromIndex;
            sublist.addAll(Arrays.asList(array).subList(fromIndex, result));
            return sublist;
        }

        @Override
        public boolean retainAll(Collection c) {
            boolean result = false;
            if (c.size() == 0) {
                return false;
            }
            for (int i = 0; i < size(); ) {
                if (c.contains(array[i])) {
                    i++;
                } else {
                    remove(array[i]);
                    result = true;
                }
            }
            return result;

        }

        @Override
        public boolean removeAll(Collection c) {
            boolean result = false;
            if (c.size() == 0) {
                return false;
            }
            for (Object o : c) {
                if (remove(o)) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public boolean containsAll(Collection c) {
            boolean result = false;
            if (c.size() == 0) {
                return false;
            }
            for (int i = 0; i < size(); ) {
                if (c.contains(array[i])) {
                    i++;
                } else {
                    remove(array[i]);
                    result = true;
                }
            }
            return result;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Object[] toArray(Object[] a) {
            if (a.length < size)
                return Arrays.copyOf(array, size, a.getClass());
            System.arraycopy(array, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }

        private boolean incrementCapasityAndGetArr() {
            return size() < capacity;
        }

        @SuppressWarnings("unchecked")
        private T[] incrementCapasityAndReturnArr() {
            T[] temp = (T[]) new Object[capacity * 3 / 2 + 1];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
            return array;
        }

        private int increaseCapasity() {

            capacity = capacity * 3 / 2 + 1;

            return capacity;
        }

        private T[] returnArr() {
            T[] result = null;
            if (size == capacity) {
                result = array;
            }
            return result;
        }

        private boolean chekCapacityForAddAll(Collection<? extends T> c) {
            return (size + c.size()) <= capacity;
        }

        private void simpleAdd(T o) {
            array[size++] = o;
        }

        private T simpleAddT(T o, int index) {
            array[index] = o;
            return o;
        }

        private void simpleAddByIndex(int index, T o) {
            array[index++] = o;
        }


        private class Arrterator implements ListIterator<T> {
            private int index;
            private int prev = -1;
            private int next = 0;
            private int itersize = ArrList.this.size();

            private boolean EqualSize() {
                return itersize == size();
            }

            public Arrterator(int index) {
            }

            public Arrterator() {

            }

            @Override
            public boolean hasNext() {
                return prev < itersize;
            }

            @Override
            public T next() {
                try {
                    index = next;
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
                return get(index);
            }

            @Override
            public boolean hasPrevious() {
                return prev > 0;
            }

            @Override
            public T previous() {
                try {
                    index = prev;
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
                return get(index);
            }

            @Override
            public int nextIndex() {
                return next;
            }

            @Override
            public int previousIndex() {
                return prev;
            }

            @Override
            public void remove() {
                if (EqualSize()) {
                    throw new ConcurrentModificationException("Size error. Iterator might be unequal current element");
                }
                ArrList.this.remove(index);
            }

            @Override
            public void set(T t) {
                if (EqualSize()) {
                    throw new ConcurrentModificationException("Size error. Iterator might be unequal current element");
                }
                ArrList.this.set(index, t);
            }

            @Override
            public void add(T t) {
                if (EqualSize()) {
                    throw new ConcurrentModificationException("Size error. Iterator might be unequal current element");
                }
                ArrList.this.add(index, t);
            }
        }
    }

}
