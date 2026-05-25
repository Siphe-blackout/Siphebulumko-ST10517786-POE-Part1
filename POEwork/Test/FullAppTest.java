import org.junit.Test;
import static org.junit.Assert.*;

public class FullAppTest{

    // Registration: Username tests
    @Test
    public void testValidUsername() {
        Registration reg = new Registration();
        assertTrue(reg.checkuserName("abc_")); // valid: <=5 chars and contains "_"
    }

    @Test
    public void testInvalidUsernameTooLong() {
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcdef_")); // too long
    }

    @Test
    public void testInvalidUsernameNoUnderscore() {
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcd")); // missing "_"
    }

    // Registration: Password tests
    @Test
    public void testValidPassword() {
        Registration reg = new Registration();
        assertTrue(reg.checkPassword("Passw0rd!")); // has uppercase, digit, special
    }

    @Test
    public void testInvalidPasswordTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Pw1!")); // too short
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("password1!")); // no uppercase
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password!")); // missing digit
    }

    @Test
    public void testInvalidPasswordNoSpecialChar() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password1")); // missing special char
    }

    // ✅ Registration: Phone number tests
    @Test
    public void testValidPhoneNumberLocal() {
        Registration reg = new Registration();
        assertTrue(reg.checkPhoneNo("0123456789")); // starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumberInternational() {
        Registration reg = new Registration();
        assertTrue(reg.checkPhoneNo("+27123456789")); // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkPhoneNo("12345")); // too short
    }

    @Test
    public void testInvalidPhoneNumberWrongPrefix() {
        Registration reg = new Registration();
        assertFalse(reg.checkPhoneNo("9912345678")); // wrong prefix
    }

    //  Login: Successful login
    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("user123", "pass123", "John", "Doe");
        String result = login.loginUser("user123", "pass123");
        assertTrue(result.startsWith("Welcome John Doe"));
    }

    //  Login: Failed login
    @Test
    public void testFailedLogin() {
        Login login = new Login("user123", "pass123", "John", "Doe");
        String result = login.loginUser("wrongUser", "wrongPass");
        assertEquals("Username or Password incorrect. Please try again.", result);
    }

    @Test
    public void testValidRecipient() {
 Message msg = new Message("+2712345678", "Hello");
 assertEquals("Cellphone number successfully captured.", msg.checkRecipientno());
 }

 @Test
 public void testInvalidRecipient() {
 Message msg = new Message("1234567890", "Hello");
 assertEquals("Cellphone number not formatted correctly. Must be 10 characters and begin with +27 international code", msg.checkRecipientno());
 }

 @Test
 public void testValidMessageLength() {
 Message msg = new Message("+2712345678", "Short message");
 assertEquals("Message ready to send.", msg.checkMessageLength());
 }

 @Test
 public void testInvalidMessageLength() {
 String longMessage = "a".repeat(260); // 260 characters
 Message msg = new Message("+2712345678", longMessage);
 assertTrue(msg.checkMessageLength().contains("Message exceeds 250 characters"));
 }

 @Test
 public void testSendMessageOptionSend() {
Message msg = new Message("+2712345678", "Hello");
 assertEquals("Message successfully sent.", msg.sendMessage("send"));
assertEquals("Sent", msg.storeMessageJSON().get("Status"));
 }

 @Test
 public void testSendMessageOptionStore() {
 Message msg = new Message("+2712345678", "Hello");
 assertEquals("Message successfully stored.", msg.sendMessage("store"));
 assertEquals("Stored", msg.storeMessageJSON().get("Status"));
 }

 @Test
public void testSendMessageOptionDiscard() {
 Message msg = new Message("+2712345678", "Hello");
 assertEquals("Press D to delete the message.", msg.sendMessage("discard"));
 assertEquals("Discarded", msg.storeMessageJSON().get("Status"));
 }

 @Test
 public void testTotalMessagesCount() {
 int before = Message.returnTotalMessages();
 Message msg = new Message("+2712345678", "Hello");
msg.sendMessage("send");
 int after = Message.returnTotalMessages();
 assertEquals(before + 1, after);
 }

 @Test
 public void testMessageHashFormat() {
 Message msg = new Message("+2712345678", "Hi there friend");
 String hash = msg.storeMessageJSON().get("MessageHash").toString();
 assertTrue(hash.matches("\\d{2}:0:[A-Z]+[A-Z]+")); // e.g., "12:0:HIFRIEND"
 }

}
