public void verifyEmail(String token) {
        Member mem = findByToken(token);

        if (mem == null) throw new BadTokenException();

        mem.checkVerificationEmailStatus();
        // ... 수정사항 DB 반영
        }

public class Member {
    int verificationEmailStatus;

    public void checkVerificationEmailStatus() {
        if (verificationEmailStatus == 2) {
            throw new AlreadyVerifiedException();
        } else {
            verificationEmailStatus = 2;
        }
    }
}