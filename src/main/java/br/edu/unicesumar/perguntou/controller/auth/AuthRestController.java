package br.edu.unicesumar.perguntou.controller.auth;

import br.edu.unicesumar.perguntou.domain.user.User;
import br.edu.unicesumar.perguntou.domain.user.UserService;
import br.edu.unicesumar.perguntou.exception.UnAuthorizationException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v0/auth")
@RestController()
public class AuthRestController {

    private final UserService userService;

    public AuthRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO dto) {
        User user = new User(null, dto.getName(), dto.getUsername(), dto.getEmail(), dto.getPassword());
        User save = userService.save(user);
        return ResponseEntity.ok(new UserDTO(save));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        User user = userService.findByUsername(login.getUsername());
        if (!user.getPassword().equals(login.getPassword())) {
            throw new UnAuthorizationException("Invalid login");
        }
        return ResponseEntity.ok("Logged in successfully");
    }
}
