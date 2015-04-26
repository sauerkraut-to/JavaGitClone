package to.sauerkraut.jgitclone.test.utilities;

public class TestErrorException extends Throwable {
    public TestErrorException(Exception e) {
        super(e);
    }

    public TestErrorException(String s, Exception e) {
        super(s,e);
    }
}
