package com.virtusa.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.model.InsertEmployeeModel;

public class EmployeeModelValidation {
public boolean validate(InsertEmployeeModel insertemployeemodel) {
		
		boolean result=false;
		
		if(validString(insertemployeemodel.getFirstName()) && validString(insertemployeemodel.getLastName()) && validNumber(insertemployeemodel.getEmployeeId()) && validSalary(insertemployeemodel.getSalary())){
			result=true;
		}	
		return result;
	}

public boolean validString(String val) {
	
	boolean result=false;
	char chars[]=val.toCharArray();
	List<Character> alphabets=new ArrayList<>();
	for(int i=97;i<=122;i++) {
		alphabets.add((char)i);
	}
	
	for(char ch:chars) {
		if(alphabets.contains(ch)) {
			result=true;
		}else {
			return false;
		}
	}
	return result;
}

public boolean validNumber(int number) {
	boolean result=false;
	String data=String.valueOf(number);
	if(data.matches("[0-9]")) {
		result=true;
	}
	return result;
}

public boolean validSalary(double salary) {
	boolean result=false;
	String salaryVal=String.valueOf((int)salary);
	if(salary>0 && salaryVal.length()<=5) {
		result=true;
	}
	return result;
}

public boolean validEmail(String email) {
	boolean result=false;
	if(email.matches("^(.+)@(.+)$")) {
		result=true;
	}
	return result;
}

public boolean validDate(LocalDate hireDate)
{
	
	boolean result=false; 
	LocalDate now = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String date = "16/08/2016";
	//convert String to LocalDate
	LocalDate localDate = LocalDate.parse(date, formatter);
	if(hireDate.isAfter(localDate) && hireDate.isBefore(now))
	{
		result=true;
	}
	else
	{
		return false;
	}
	return result;
}
public boolean validDob(LocalDate dateOfBirth)
{
	boolean result=false;
	LocalDate now = LocalDate.now();
	int localdateYear=now.getYear();
	int dobYear= dateOfBirth.getYear();
	
	if((localdateYear-dobYear)>=21)
	{
		return true;
	}	
	return result;	
}

public boolean validPhoneNum(String newphoneNumber)
{
	boolean result=false;
	if((newphoneNumber.length()==12)&&(newphoneNumber.matches("[0-9]+")))
	{
		result=true;
	}	
	return result;
}

}
