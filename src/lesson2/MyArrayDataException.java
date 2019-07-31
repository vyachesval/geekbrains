package lesson2;

public class MyArrayDataException extends NumberFormatException {

    int row;
    int column;


    public MyArrayDataException(int r, int c, String data) {
        super(data);
        this.row = r;
        this.column = c;
    }

    String getError()
    {
        return "Ошибка в ячейке " + row + "x" + column + ", невалидное значение " + getMessage();
    }
}
