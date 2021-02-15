package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {
                {"5", "10", "15", "20"},
                {"25", "30", "35", "40"},
                {"45", "50", "55", "60"},
                {"65", "70", "75", "восемьдесят"}
        };

        try {
            arrayExceptionTest(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static void arrayExceptionTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int intArr[][] = new int[4][4];
        int sum = 0;
        if (arr.length != 4) {
            System.out.println();
            throw new MyArraySizeException("неверное количество строк");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                System.out.println();
                throw new MyArraySizeException("неверное количество столбцов в " + (i+1) + "-й" +
                        " строке");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    intArr[i][j] = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("Сумма всех элементов до ошибочного составила " + sum);
                    throw new MyArrayDataException("невозможно преобразовать в число элемент " + (i+1) +
                            " строки, " + (j+1) + " столбца.");
                }
                sum +=intArr[i][j];
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Сумма всех элементов равна " + sum);
    }
}
