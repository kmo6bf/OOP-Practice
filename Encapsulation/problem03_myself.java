Timer t = new Timer();
t.startTime = System.currentTimeMillis();

        ...

t.stopTime = System.currentTimeMillis();

long elaspedTime = t.stopTime - t.startTime;


public class Timer {
    public long startTime;
    public long stopTime;
}

// 어떻게 캡슐화 해야할지 감이 안온다...