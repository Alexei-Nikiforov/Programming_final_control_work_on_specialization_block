class Counters implements AutoCloseable {
    
    private int count = 0;

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        if (count == 0) {
            throw new Exception("Счетчик не использовался или все еще открыт.");
        }
    }

}