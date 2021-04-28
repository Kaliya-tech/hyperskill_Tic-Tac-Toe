class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (hours == 12 && minutes == 59) {
            hours = 1;
            minutes = 0;
        } else if (minutes == 59) {
            hours += 1;
            minutes = 0;
        } else {
            minutes += 1;
        }
    }
}
  /*  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int hours = scanner.nextInt();
    int minutes = scanner.nextInt();
        next(int, int);
    }*/