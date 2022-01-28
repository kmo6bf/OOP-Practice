Timer t = new Timer();
// 타이머를 시작하는 기능이다.
t.start();

        ...

// 타이머를 중지하는 기능이다.
t.stop();

// 중지 시간과 시작 시간 사이의 차이를 구함
long time = t.elapsedTime(MILLISECOND);


public class Timer {
    public long startTime;
    public long stopTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    // 우리가 만약 시간의 단위를 밀리초가 아니라 나노초 단위로 구하고 싶다면
    // 아래 메서드의 파라미터만 변경해주면 된다.
    public long elapsedTime(TimeUnit unit) {
        switch(unit) {
            case MILLISECOND;
                return stopTime - startTime;
            ...
            // 구하는 시간의 단위가 나노 초일 경우
            case NANO;
                return stopTime - startTime;
        }
    }
}


// 기존 코드는 Timer의 데이터를 그대로 사용하고 있으므로 굉장히 절차지향적인 코드이다.
//