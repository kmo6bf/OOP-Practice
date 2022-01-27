public AuthResult authenticate(String id, String pw) {
        Member mem = findOne(id);

        if (mem == null) return AuthResult.NO_MATCH;

        // Tell, Don't ASK 규칙에 따라 데이터를 직접 가져와서 판단하는게 아닌
        // 데이터를 가지고 있는 클래스에게 요청하도록 코드를 캡슐화하였다.
        if (!mem.isEmailVerified()) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (passwordEncoder.isPasswordValid(mem.getPassword(), pw, mem, getId())) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
}

// Member 클래스에 캡슐화를 위한 메서드 추가
public class Member {
    private int verificationEmailStatus;

    public boolean isEmailVerified() {
        return verificationEmailStatus == 2;
    }
}