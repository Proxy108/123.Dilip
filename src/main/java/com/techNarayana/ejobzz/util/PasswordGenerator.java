package com.techNarayana.ejobzz.util;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
@Component
public class PasswordGenerator{
	private static Logger logger=Logger.getLogger(PasswordGenerator.class);
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    private static final int RANDOM_STRING_LENGTH = 8;
	     
	    /**
	     * This method generates random string
	     * @return
	     */
	    public String generateRandomString(){
	         logger.debug("Inside generating password");
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        logger.debug("Generated Password is "+randStr.toString());
	        return randStr.toString();
	    }
	     
	    /**
	     * This method generates random numbers
	     * @return int
	     */
	    private int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	     
	   /* public static void main(String a[]){
	    	PasswordGenerator msr = new PasswordGenerator();
	    	PasswordEncrypit en=new PasswordEncrypit("");
	    	//System.out.println(en.encrypt(msr.generateRandomString()));
	    	System.out.println(en.decrypt("/c2NLsfWt7VCvuypsTE4Zg=="));
	        
	    }*/
}