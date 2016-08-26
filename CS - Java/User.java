/**
 * A public class that makes a User object.
 * @author Stephanie Remy
 *
 */
public class User implements java.lang.Comparable<User> {

	private String name;
	private String userName;

    /**
     * Public constructor for User.
     * 
     * @param name The name of the user.
     * @param userName The username of the user.
     */
    public User(String name, String userName) {
    	this.name = name;
    	this.userName = userName;
    }
    /**
     * An equals method to compare Users.
     * @param anotherUser The user being compared to this object.
     * @return boolean True of they equal, false otherwise.
     */
    public boolean equals(User anotherUser) {
    	return (this.userName.compareTo(anotherUser.userName) == 0);
    }
    @Override
	public int compareTo(User anotherUser) {
		String tempUserName = this.userName;
		String tempAnotherName = anotherUser.userName;
		return tempUserName.compareToIgnoreCase(tempAnotherName);
	}
    /**
     * A public getter method to get the name for the 'find' feature in Driver.
     * @return The name of this object User.
     */
    public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return userName + "-" + name;
	}
}
