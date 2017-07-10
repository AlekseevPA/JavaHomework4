package phonebook;

public class Phone {
	protected String phone; // телефон

	public Phone(String phone) { // перегруженный конструктор
		this.phone = phone;
	}

	public String getPhone() { // геттер
		return phone;
	}

	public void setPhone(String phone) { // сеттер
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
		//return 1;
	}
}
