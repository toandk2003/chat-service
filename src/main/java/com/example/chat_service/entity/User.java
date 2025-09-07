package com.example.chat_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    @Id
    private String id;

    @Field("userId")
    private String userId; // Shard key

    // Basic Info (10 fields)
    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("middleName")
    private String middleName;

    @Field("email")
    private String email;

    @Field("phone")
    private String phone;

    @Field("username")
    private String username;

    @Field("displayName")
    private String displayName;

    @Field("nickname")
    private String nickname;

    @Field("title")
    private String title;

    @Field("bio")
    private String bio;

    // Address Info (15 fields)
    @Field("street1")
    private String street1;

    @Field("street2")
    private String street2;

    @Field("city")
    private String city;

    @Field("state")
    private String state;

    @Field("zipCode")
    private String zipCode;

    @Field("country")
    private String country;

    @Field("homeAddress")
    private String homeAddress;

    @Field("workAddress")
    private String workAddress;

    @Field("billingAddress")
    private String billingAddress;

    @Field("shippingAddress")
    private String shippingAddress;

    @Field("latitude")
    private Double latitude;

    @Field("longitude")
    private Double longitude;

    @Field("timezone")
    private String timezone;

    @Field("region")
    private String region;

    @Field("locale")
    private String locale;

    // Personal Details (20 fields)
    @Field("age")
    private Integer age;

    @Field("dateOfBirth")
    private LocalDateTime dateOfBirth;

    @Field("gender")
    private String gender;

    @Field("nationality")
    private String nationality;

    @Field("maritalStatus")
    private String maritalStatus;

    @Field("occupation")
    private String occupation;

    @Field("company")
    private String company;

    @Field("department")
    private String department;

    @Field("position")
    private String position;

    @Field("salary")
    private Double salary;

    @Field("education")
    private String education;

    @Field("university")
    private String university;

    @Field("degree")
    private String degree;

    @Field("graduationYear")
    private Integer graduationYear;

    @Field("skills")
    private List<String> skills;

    @Field("languages")
    private List<String> languages;

    @Field("hobbies")
    private List<String> hobbies;

    @Field("interests")
    private List<String> interests;

    @Field("emergencyContact")
    private String emergencyContact;

    @Field("emergencyPhone")
    private String emergencyPhone;

    // System Fields (10 fields)
    @Field("createdAt")
    private LocalDateTime createdAt;

    @Field("updatedAt")
    private LocalDateTime updatedAt;

    @Field("lastLoginAt")
    private LocalDateTime lastLoginAt;

    @Field("isActive")
    private Boolean isActive;

    @Field("isVerified")
    private Boolean isVerified;

    @Field("accountStatus")
    private String accountStatus;

    @Field("accountType")
    private String accountType;

    @Field("subscriptionLevel")
    private String subscriptionLevel;

    @Field("creditScore")
    private Integer creditScore;

    @Field("loyaltyPoints")
    private Long loyaltyPoints;

    // Preferences (15 fields)
    @Field("theme")
    private String theme;

    @Field("language")
    private String language;

    @Field("currency")
    private String currency;

    @Field("notifications")
    private Boolean notifications;

    @Field("emailNotifications")
    private Boolean emailNotifications;

    @Field("smsNotifications")
    private Boolean smsNotifications;

    @Field("pushNotifications")
    private Boolean pushNotifications;

    @Field("marketingEmails")
    private Boolean marketingEmails;

    @Field("newsletter")
    private Boolean newsletter;

    @Field("privacy")
    private String privacy;

    @Field("visibility")
    private String visibility;

    @Field("searchable")
    private Boolean searchable;

    @Field("twoFactorAuth")
    private Boolean twoFactorAuth;

    @Field("sessionTimeout")
    private Integer sessionTimeout;

    @Field("autoLogout")
    private Boolean autoLogout;

    // Social Media (10 fields)
    @Field("facebookUrl")
    private String facebookUrl;

    @Field("twitterUrl")
    private String twitterUrl;

    @Field("linkedinUrl")
    private String linkedinUrl;

    @Field("instagramUrl")
    private String instagramUrl;

    @Field("githubUrl")
    private String githubUrl;

    @Field("websiteUrl")
    private String websiteUrl;

    @Field("blogUrl")
    private String blogUrl;

    @Field("youtubeUrl")
    private String youtubeUrl;

    @Field("tiktokUrl")
    private String tiktokUrl;

    @Field("discordUrl")
    private String discordUrl;

    // Financial Info (10 fields)
    @Field("bankAccount")
    private String bankAccount;

    @Field("bankName")
    private String bankName;

    @Field("routingNumber")
    private String routingNumber;

    @Field("creditCardLast4")
    private String creditCardLast4;

    @Field("paypalEmail")
    private String paypalEmail;

    @Field("bitcoinAddress")
    private String bitcoinAddress;

    @Field("annualIncome")
    private Double annualIncome;

    @Field("monthlyExpenses")
    private Double monthlyExpenses;

    @Field("investmentProfile")
    private String investmentProfile;

    @Field("riskTolerance")
    private String riskTolerance;

    // Health & Fitness (10 fields)
    @Field("height")
    private Double height;

    @Field("weight")
    private Double weight;

    @Field("bloodType")
    private String bloodType;

    @Field("allergies")
    private List<String> allergies;

    @Field("medications")
    private List<String> medications;

    @Field("fitnessLevel")
    private String fitnessLevel;

    @Field("dietaryRestrictions")
    private List<String> dietaryRestrictions;

    @Field("smokingStatus")
    private String smokingStatus;

    @Field("drinkingStatus")
    private String drinkingStatus;

    @Field("exerciseFrequency")
    private String exerciseFrequency;

    // Additional Metadata (10 fields)
    @Field("tags")
    private List<String> tags;

    @Field("categories")
    private List<String> categories;

    @Field("customFields")
    private Map<String, Object> customFields;

    @Field("metadata")
    private Map<String, String> metadata;

    @Field("notes")
    private String notes;

    @Field("comments")
    private String comments;

    @Field("rating")
    private Double rating;

    @Field("reviewCount")
    private Integer reviewCount;

    @Field("favoriteColor")
    private String favoriteColor;

    @Field("favoriteFood")
    private String favoriteFood;

    // Total: 100+ fields
}