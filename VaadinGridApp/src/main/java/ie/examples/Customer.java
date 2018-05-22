package ie.examples;

class Customer
{
    private String first_name;
    private String last_name;
    private boolean paid;
    private double amount;

    Customer(String first_name, String last_name, boolean paid, double amount)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.paid = paid;
        this.amount = amount;
    }
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}