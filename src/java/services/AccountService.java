package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {

    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);

                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";

                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());

                GmailService.sendMail(to, subject, template, tags);
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void resetPassword(String email, String path, String url) {
        UserDB ub = new UserDB();
        try {
            User user = ub.get(email);
            String uuid = UUID.randomUUID().toString();
            user.setResetPasswordUuid(uuid);
            ub.update(user);
            String subject = "Notes App Password Reset";
            String template = path + "/emailtemplates/resetpassword.html";
            String link = url + "?uuid=" + uuid;
            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("link", link);
            GmailService.sendMail(email, subject, template, tags);
        } catch (Exception e) {
        }
    }

    public boolean changePassword(String uuid, String password) {
        UserDB ub = new UserDB();
        try {
            User user = ub.getByUUID(uuid);
            user.setPassword(password);
            user.setResetPasswordUuid(null);
            ub.update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
