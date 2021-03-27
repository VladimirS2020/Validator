import service.UserService;

import java.time.Period;

public class Main {
    public static void main(String[] args) {
        UserService service = UserService.getInstance();

        // Выводим на экран самого СТАРОГО пользователя
        System.out.println(service.getReducedUser(
                (user1, user2) -> {
                    return Period.between(user1.getBirthday(), user2.getBirthday()).getYears() > 0 ? user1 : user2;
                }));

        // Выводим на экран самого МОЛОДОГО пользователя
        System.out.println(service.getReducedUser(
                (user1, user2) -> {
                    return Period.between(user1.getBirthday(), user2.getBirthday()).getYears() > 0 ? user2 : user1;
                }));

    }
}