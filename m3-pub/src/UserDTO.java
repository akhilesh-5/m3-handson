/**
 * Session M3 Part A / B: replace this empty record header with the
 * fields Copilot suggests once you re-trigger ghost text after
 * opening User.java in a second tab. Then add a static
 * {@code fromUser(User)} mapper as described in Part B.
 */
public record UserDTO(String id, String name, String email, boolean active) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(
            String.valueOf(user.getId()),
            user.getName(),
            user.getEmail(),
            user.isActive()
        );
    }

    public static void main(String[] args) {
        User user = new User(1L, "Alice", "alice@example.com", true);
        System.out.println(UserDTO.fromUser(user));
    }
}
