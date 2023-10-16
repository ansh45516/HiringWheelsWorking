package org.ncu.hirewheels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // The name of the database table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

	@Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "mobile_no", length = 10, nullable = false, unique = true)
    private String mobileNo;

//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
//    private Role role;

    @Column(name = "wallet_money", precision = 10, scale = 2, columnDefinition = "NUMERIC(10,2) default 10000.00")
    private float walletMoney;

    // Getters and setters for the above attributes

    // You can also add constructors and other methods as needed

    public User(Long userId, String firstName, String lastName, String password, String email, String mobileNo,
			float walletMoney) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.walletMoney = walletMoney;
	}
    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public float getWalletMoney() {
		return walletMoney;
	}

	public void setWalletMoney(float walletMoney) {
		this.walletMoney = walletMoney;
	}

	@Override
    public String toString() {
        return """
               User{\
               userId=\
               """ + userId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               // Include other attributes as needed
               '}';
    }
}
