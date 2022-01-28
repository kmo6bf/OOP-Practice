public void verifyEmail(String token) {
    Member mem = findByToken(token);

    if (mem == null) throw new BadTokenException();

    if (mem.getVerificationEmailStatus() == 2) {
        throw new AlreadyVerifiedException();
    } else {
        mem.setVerificationEmailStatus(2);
    }
    // ... 수정사항 DB 반영
}