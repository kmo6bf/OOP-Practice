public AuthResult authenticate(String id, String pw) {
        Member mem = findOne(id);
        if (mem == null) return AuthResult.NO_MATCH;

        if (mem.getVerificationEmailStatus() != 2) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (passwordEncoder.isPasswordValid(mem.getPassword(), pw, mem, getId())) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
}
