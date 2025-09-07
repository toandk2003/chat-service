package com.example.chat_service;

import com.example.chat_service.entity.User;
import com.example.chat_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
@AllArgsConstructor
@Slf4j
public class SeedData {

    @Bean
    public CommandLineRunner seedMassiveUsers(UserRepository userRepository) {
        return args -> {
            // Clear existing data
//            log.info("Clearing existing users...");
            userRepository.deleteAll();

            log.info("Starting to seed 100,000 users with 100+ fields each...");

            int batchSize = 0;
            int totalUsers = 0;
            Random random = new Random();

            // Sample data arrays for randomization
            String[] firstNames = {"John", "Jane", "Michael", "Sarah", "David", "Emily", "Robert", "Jessica", "William", "Ashley"};
            String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
            String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose"};
            String[] countries = {"USA", "Canada", "UK", "Germany", "France", "Japan", "Australia", "Brazil", "India", "China"};
            String[] companies = {"Google", "Microsoft", "Apple", "Amazon", "Facebook", "Tesla", "Netflix", "Uber", "Spotify", "Twitter"};
            String[] skills = {"Java", "Python", "JavaScript", "React", "Node.js", "Docker", "Kubernetes", "AWS", "MongoDB", "Spring Boot"};
            String[] hobbies = {"Reading", "Gaming", "Cooking", "Travel", "Photography", "Music", "Sports", "Art", "Yoga", "Hiking"};

            for (int batch = 0; batch < totalUsers / batchSize; batch++) {
                List<User> users = new ArrayList<>();

                for (int i = 0; i < batchSize; i++) {
                    int userIndex = batch * batchSize + i;

                    // Generate diverse userId for better shard distribution
                    String userId = generateDiverseUserId(userIndex, random);

                    User user = User.builder()
                            // Core fields
                            .id(UUID.randomUUID().toString())
                            .userId(userId) // Shard key

                            // Basic Info
                            .firstName(firstNames[random.nextInt(firstNames.length)])
                            .lastName(lastNames[random.nextInt(lastNames.length)])
                            .middleName("Middle" + userIndex)
                            .email("user" + userIndex + "@example.com")
                            .phone("+1" + (1000000000L + random.nextInt(900000000)))
                            .username("user" + userIndex)
                            .displayName("Display User " + userIndex)
                            .nickname("Nick" + userIndex)
                            .title("Mr/Ms")
                            .bio("This is a bio for user " + userIndex + " with some additional text to increase document size")

                            // Address Info
                            .street1(random.nextInt(9999) + " Main Street")
                            .street2("Apt " + random.nextInt(999))
                            .city(cities[random.nextInt(cities.length)])
                            .state("State" + (userIndex % 50))
                            .zipCode(String.format("%05d", random.nextInt(99999)))
                            .country(countries[random.nextInt(countries.length)])
                            .homeAddress("Home address for user " + userIndex)
                            .workAddress("Work address for user " + userIndex)
                            .billingAddress("Billing address for user " + userIndex)
                            .shippingAddress("Shipping address for user " + userIndex)
                            .latitude(random.nextDouble() * 180 - 90)
                            .longitude(random.nextDouble() * 360 - 180)
                            .timezone("UTC" + (random.nextInt(24) - 12))
                            .region("Region" + (userIndex % 10))
                            .locale("en_US")

                            // Personal Details
                            .age(18 + random.nextInt(65))
                            .dateOfBirth(LocalDateTime.now().minusYears(random.nextInt(50) + 18))
                            .gender(random.nextBoolean() ? "Male" : "Female")
                            .nationality(countries[random.nextInt(countries.length)])
                            .maritalStatus(random.nextBoolean() ? "Single" : "Married")
                            .occupation("Occupation" + userIndex)
                            .company(companies[random.nextInt(companies.length)])
                            .department("Department" + (userIndex % 20))
                            .position("Position" + userIndex)
                            .salary(30000.0 + random.nextDouble() * 170000)
                            .education("Bachelor's Degree")
                            .university("University" + (userIndex % 100))
                            .degree("Computer Science")
                            .graduationYear(1990 + random.nextInt(30))
                            .skills(Arrays.asList(
                                    skills[random.nextInt(skills.length)],
                                    skills[random.nextInt(skills.length)],
                                    skills[random.nextInt(skills.length)]
                            ))
                            .languages(Arrays.asList("English", "Spanish"))
                            .hobbies(Arrays.asList(
                                    hobbies[random.nextInt(hobbies.length)],
                                    hobbies[random.nextInt(hobbies.length)]
                            ))
                            .interests(Arrays.asList("Technology", "Science", "Art"))
                            .emergencyContact("Emergency Contact " + userIndex)
                            .emergencyPhone("+1" + (1000000000L + random.nextInt(900000000)))

                            // System Fields
                            .createdAt(LocalDateTime.now().minusDays(random.nextInt(365)))
                            .updatedAt(LocalDateTime.now().minusDays(random.nextInt(30)))
                            .lastLoginAt(LocalDateTime.now().minusHours(random.nextInt(24)))
                            .isActive(random.nextBoolean())
                            .isVerified(random.nextBoolean())
                            .accountStatus(random.nextBoolean() ? "ACTIVE" : "INACTIVE")
                            .accountType(random.nextBoolean() ? "PREMIUM" : "BASIC")
                            .subscriptionLevel("Level" + (random.nextInt(5) + 1))
                            .creditScore(300 + random.nextInt(550))
                            .loyaltyPoints(random.nextLong() % 10000)

                            // Preferences
                            .theme(random.nextBoolean() ? "DARK" : "LIGHT")
                            .language("en")
                            .currency("USD")
                            .notifications(random.nextBoolean())
                            .emailNotifications(random.nextBoolean())
                            .smsNotifications(random.nextBoolean())
                            .pushNotifications(random.nextBoolean())
                            .marketingEmails(random.nextBoolean())
                            .newsletter(random.nextBoolean())
                            .privacy(random.nextBoolean() ? "PUBLIC" : "PRIVATE")
                            .visibility(random.nextBoolean() ? "VISIBLE" : "HIDDEN")
                            .searchable(random.nextBoolean())
                            .twoFactorAuth(random.nextBoolean())
                            .sessionTimeout(30 + random.nextInt(120))
                            .autoLogout(random.nextBoolean())

                            // Social Media
                            .facebookUrl("https://facebook.com/user" + userIndex)
                            .twitterUrl("https://twitter.com/user" + userIndex)
                            .linkedinUrl("https://linkedin.com/in/user" + userIndex)
                            .instagramUrl("https://instagram.com/user" + userIndex)
                            .githubUrl("https://github.com/user" + userIndex)
                            .websiteUrl("https://user" + userIndex + ".com")
                            .blogUrl("https://blog.user" + userIndex + ".com")
                            .youtubeUrl("https://youtube.com/user" + userIndex)
                            .tiktokUrl("https://tiktok.com/@user" + userIndex)
                            .discordUrl("user" + userIndex + "#1234")

                            // Financial Info
                            .bankAccount("****" + String.format("%04d", random.nextInt(9999)))
                            .bankName("Bank" + (userIndex % 10))
                            .routingNumber(String.format("%09d", random.nextInt(999999999)))
                            .creditCardLast4(String.format("%04d", random.nextInt(9999)))
                            .paypalEmail("paypal" + userIndex + "@example.com")
                            .bitcoinAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa" + userIndex)
                            .annualIncome(40000.0 + random.nextDouble() * 160000)
                            .monthlyExpenses(2000.0 + random.nextDouble() * 8000)
                            .investmentProfile(random.nextBoolean() ? "CONSERVATIVE" : "AGGRESSIVE")
                            .riskTolerance(random.nextBoolean() ? "LOW" : "HIGH")

                            // Health & Fitness
                            .height(150.0 + random.nextDouble() * 50)
                            .weight(50.0 + random.nextDouble() * 100)
                            .bloodType(Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-").get(random.nextInt(8)))
                            .allergies(Arrays.asList("Peanuts", "Shellfish"))
                            .medications(Arrays.asList("Medication" + userIndex))
                            .fitnessLevel(Arrays.asList("LOW", "MEDIUM", "HIGH").get(random.nextInt(3)))
                            .dietaryRestrictions(Arrays.asList("Vegetarian", "Vegan"))
                            .smokingStatus(random.nextBoolean() ? "NON_SMOKER" : "SMOKER")
                            .drinkingStatus(random.nextBoolean() ? "NON_DRINKER" : "SOCIAL_DRINKER")
                            .exerciseFrequency(Arrays.asList("DAILY", "WEEKLY", "MONTHLY", "NEVER").get(random.nextInt(4)))

                            // Additional Metadata
                            .tags(Arrays.asList("tag1", "tag2", "tag3"))
                            .categories(Arrays.asList("category1", "category2"))
                            .notes("Notes for user " + userIndex + " with additional text to increase document size")
                            .comments("Comments for user " + userIndex)
                            .rating(1.0 + random.nextDouble() * 4.0)
                            .reviewCount(random.nextInt(100))
                            .favoriteColor(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple").get(random.nextInt(5)))
                            .favoriteFood(Arrays.asList("Pizza", "Sushi", "Burger", "Pasta", "Salad").get(random.nextInt(5)))

                            .build();

                    users.add(user);
                }

                // Batch save
                userRepository.saveAll(users);
                log.info("Saved batch {}/{} ({} users total)",
                        batch + 1, totalUsers / batchSize, (batch + 1) * batchSize);

                // Small delay to prevent overwhelming the database
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            log.info("Successfully seeded {} users with 100+ fields each!", totalUsers);
            log.info("Estimated total data size: ~{}MB", (totalUsers * 2) / 1000); // Rough estimate
            log.info("Check shard distribution with: docker exec -it mongos mongosh --eval \"use chat_service; db.users.getShardDistribution()\"");
        };
    }

    /**
     * Generate diverse userId for better shard distribution
     */
    private String generateDiverseUserId(int index, Random random) {
        // Multiple strategies to ensure good distribution across shards
        if (index % 4 == 0) {
            // Numeric: 00000001, 00000002, etc.
            return String.format("%08d", index);
        } else if (index % 4 == 1) {
            // Alphabetic: aaaaaaaa, aaaaaaab, etc.
            return generateAlphabeticId(index);
        } else if (index % 4 == 2) {
            // UUID-based (guaranteed diversity)
            return UUID.randomUUID().toString().replace("-", "");
        } else {
            // Mixed format
            return "usr_" + index + "_" + Math.abs(random.nextInt());
        }
    }

    private String generateAlphabeticId(int index) {
        StringBuilder sb = new StringBuilder();
        int temp = index;

        for (int i = 0; i < 8; i++) {
            sb.append((char) ('a' + (temp % 26)));
            temp /= 26;
        }

        return sb.toString();
    }
}