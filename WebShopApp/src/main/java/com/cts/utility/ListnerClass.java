package com.cts.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cts.baseclass.BaseClass;
//listher class to take screen shot by using itest listner
public class ListnerClass implements ITestListener  {
	 BaseClass baseclass=new BaseClass();
	 public void onTestStart(ITestResult result) {  
	        // TODO Auto-generated method stub  
	          
	    }  
	  
	    public void onTestSuccess(ITestResult result) {  
	        // TODO Auto-generated method stub 

	    	try {
				baseclass.getScreenshot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Success of test cases and its details are : "+result.getName());  
	    }  
	  
	    public void onTestFailure(ITestResult result) {  
	        // TODO Auto-generated method stub  
	        System.out.println("Failure of test cases and its details are : "+result.getName());  
	    }  
	  
	    public void onTestSkipped(ITestResult result) {  
	        // TODO Auto-generated method stub  
	        System.out.println("Skip of test cases and its details are : "+result.getName());  
	    }  
	  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        // TODO Auto-generated method stub  
	        System.out.println("Failure of test cases and its details are : "+result.getName());  
	    }  
	  
	    public void onStart(ITestContext context) {  
	        // TODO Auto-generated method stub  
	          
	    }  
	  
	    public void onFinish(ITestContext context) {  
	        // TODO Auto-generated method stub  
	          
	    }  
	
}
