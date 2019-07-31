package lesson2;

public class MyArrayDataException extends Exception {

    int row;
    int column;

    String data;

    public MyArrayDataException(int r, int c, String data) {
        super();
        this.row = r;
        this.column = c;
        this.data = data;
    }

    String getError()
    {
        return "Ошибка в ячейке " + row + "x" + column + ", невалидное значение " + data;
    }
}
