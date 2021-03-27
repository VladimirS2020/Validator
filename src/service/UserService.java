package service;

import model.User;
import util.Validator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class UserService {
    private static UserService userService;
    private List<User> data = new ArrayList<>();

    {
        data.add(new User("Egor_20", "Ivanov", LocalDate.now().minusYears(20)));
        data.add(new User("Ivan_10", "Ivanov", LocalDate.now().minusYears(10)));
        data.add(new User("Egor_40", "Olegov", LocalDate.now().minusYears(40)));
        data.add(new User("Oleg_12", "Ivanov", LocalDate.now().minusYears(12)));
        data.add(new User("Sergey_25", "Ivanov", LocalDate.now().minusYears(25)));
    }

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public Optional<User> getUserById(int id) {
        if (id < data.size()) {
            return Optional.of(data.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<User> getData() {
        return data;
    }

    public List<User> getValidUsers(Validator validator) {
        return data.stream()
                .filter(validator::validate)
                .collect(Collectors.toList());
    }

    public Optional<User>getReducedUser(BinaryOperator<User> binaryOperator){
        return data.stream()
                .reduce(binaryOperator);
    }

    public List<User> getSortedUsers(Comparator<User> comparator){
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}