package vadim_nedrega.HW12_DataStreams.HW_data.DataImageStore;

public class Program_12_04 {
    public static void main(String[] args) {
        String filePath = "D:\\Обучение IT\\Java Elementary\\Test\\";
        String fileName = "Picture.png";

        DataStoreImage<ImageData> dataStoreImage = new FileDataStoreImage<>(filePath, fileName);

        ImageData imageData = dataStoreImage.load();

        System.out.println("Ширина картинки: " + imageData.getImageWidth() + " пикселей");
        System.out.println("Длина картинки: " + imageData.getImageHeight() + " пикселей");


    }
}
