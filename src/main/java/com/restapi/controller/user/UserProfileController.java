package com.restapi.controller.user;

import com.restapi.model.user.ApiResponse;
import com.restapi.model.user.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    
    private List<UserProfile> users = new ArrayList<>();
    private Long nextId = 6L;

    public UserProfileController() {
        // Initialize with sample users
        users.add(new UserProfile(1L, "john_doe", "john@email.com", "John Doe", 28, "USA", "Software developer", true));
        users.add(new UserProfile(2L, "jane_smith", "jane@email.com", "Jane Smith", 25, "Canada", "Designer", true));
        users.add(new UserProfile(3L, "mike_wilson", "mike@email.com", "Mike Wilson", 35, "UK", "Project manager", false));
        users.add(new UserProfile(4L, "sarah_jones", "sarah@email.com", "Sarah Jones", 30, "USA", "Data analyst", true));
        users.add(new UserProfile(5L, "tom_brown", "tom@email.com", "Tom Brown", 22, "Australia", "Student", true));
    }

    // GET /api/users - Get all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(
            true,
            "Users retrieved successfully",
            users
        );
        return ResponseEntity.ok(response);
    }

    // GET /api/users/{userId} - Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .map(user -> {
                    ApiResponse<UserProfile> response = new ApiResponse<>(
                        true,
                        "User found successfully",
                        user
                    );
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    ApiResponse<UserProfile> response = new ApiResponse<>(
                        false,
                        "User not found",
                        null
                    );
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                });
    }

    // GET /api/users/search/username?username={username} - Search by username
    @GetMapping("/search/username")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getUsername().toLowerCase().contains(username.toLowerCase()))
                .collect(Collectors.toList());
        
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(
            true,
            "Search completed successfully",
            result
        );
        return ResponseEntity.ok(response);
    }

    // GET /api/users/search/country?country={country} - Search by country
    @GetMapping("/search/country")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByCountry(@RequestParam String country) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(
            true,
            "Users from " + country + " retrieved successfully",
            result
        );
        return ResponseEntity.ok(response);
    }

    // GET /api/users/search/age-range?min={min}&max={max} - Search by age range
    @GetMapping("/search/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getAge() >= min && user.getAge() <= max)
                .collect(Collectors.toList());
        
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(
            true,
            "Users in age range " + min + "-" + max + " retrieved successfully",
            result
        );
        return ResponseEntity.ok(response);
    }

    // POST /api/users - Create new user profile
    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        user.setUserId(nextId++);
        users.add(user);
        
        ApiResponse<UserProfile> response = new ApiResponse<>(
            true,
            "User profile created successfully",
            user
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // PUT /api/users/{userId} - Update user profile
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(
            @PathVariable Long userId,
            @RequestBody UserProfile updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                updatedUser.setUserId(userId);
                users.set(i, updatedUser);
                
                ApiResponse<UserProfile> response = new ApiResponse<>(
                    true,
                    "User profile updated successfully",
                    updatedUser
                );
                return ResponseEntity.ok(response);
            }
        }
        
        ApiResponse<UserProfile> response = new ApiResponse<>(
            false,
            "User not found",
            null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // PATCH /api/users/{userId}/activate - Activate user profile
    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                
                ApiResponse<UserProfile> response = new ApiResponse<>(
                    true,
                    "User profile activated successfully",
                    user
                );
                return ResponseEntity.ok(response);
            }
        }
        
        ApiResponse<UserProfile> response = new ApiResponse<>(
            false,
            "User not found",
            null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // PATCH /api/users/{userId}/deactivate - Deactivate user profile
    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                
                ApiResponse<UserProfile> response = new ApiResponse<>(
                    true,
                    "User profile deactivated successfully",
                    user
                );
                return ResponseEntity.ok(response);
            }
        }
        
        ApiResponse<UserProfile> response = new ApiResponse<>(
            false,
            "User not found",
            null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // DELETE /api/users/{userId} - Delete user profile
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        boolean removed = users.removeIf(user -> user.getUserId().equals(userId));
        
        if (removed) {
            ApiResponse<Void> response = new ApiResponse<>(
                true,
                "User profile deleted successfully",
                null
            );
            return ResponseEntity.ok(response);
        }
        
        ApiResponse<Void> response = new ApiResponse<>(
            false,
            "User not found",
            null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
