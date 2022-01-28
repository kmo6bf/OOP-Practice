public void verifyEmail(String token) {
    Member mem = findByToken(token);

    if (mem == null) throw new BadTokenException();

    // 데이터를 직접 가져와서 판단하고 있다.
    // 데이터를 직접 변경해주고 있다.
    // 캡슐화를 위해 해당 메서드를 통째 로 Member클래스에 정의해준다.
    mem.verifyEmail();

    // ... 수정사항 DB 반영
}

public class Member {
    private int verificationEmailStatus;

    public void verifyEmail() {
        if (isEmailVerified()) {
            throw new AlreadyVerifiedException();
        } else {
            verificationEmailStatus = 2;
        }
    }

    // 메서드가 하나의 역할만 수행하도록 분
    public boolean isEmailVerified() {
        return verificationEmailStatus == 2;
    }
}

