package JavaIntro2;

class NoStackTraceRuntimeException extends Exception {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

public class CustomException
{
    public static void main(String[] args) {
        try {
            throw new NoStackTraceRuntimeException();
        } catch (NoStackTraceRuntimeException e) {
            System.out.println(e.getStackTrace());
        }
    }
}

