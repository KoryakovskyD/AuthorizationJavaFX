package com.example.authorizationjavafx;

public class UserController {
    public boolean checkData(String name, String pass, String repPass) throws UserException {
        if (name.isEmpty()) throw new UserException("Name can't be null");
        if (!pass.equals(repPass))
            throw new UserException("Passwords doesn't same");
        String regex = "A-Za-z0-9!";
        if (pass.replaceAll("[" + regex + "]", "").length() > 0)
            throw new UserException("Password can contain characters: ");
        User user = new User(name, pass);
        return true;
    }
}
