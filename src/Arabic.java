

 class Arabic extends Number {

    private int value1;
    private int value2;
    private int result;

    Arabic(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void sum() {
        this.result = value1 + value2;
    }

    public void sub() {
        this.result = value1 - value2;
    }

    public void div() {
        try{
            this.result = value1 / value2;
        } catch (ArithmeticException e) {
            System.out.print("Деление на 0! ");
            return;
        }

    }

    public void mul() {
        this.result = value1 * value2;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }


}