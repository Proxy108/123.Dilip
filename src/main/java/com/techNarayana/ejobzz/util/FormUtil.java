package com.techNarayana.ejobzz.util;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {
	
	

	public FormUtil() {
	}

	public static String getFieldValue(HttpServletRequest request,	String fieldName) {
		String value = request.getParameter(fieldName);
		return isEmpty(value) ? null : value.trim();
	}
	

	public static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		} else if (value instanceof String) {
			return ((String) value).trim().length() == 0;
		} else if (value instanceof Object[]) {
			return ((Object[]) value).length == 0;
		} else if (value instanceof Collection<?>) {
			return ((Collection<?>) value).size() == 0;
		} else if (value instanceof Map<?, ?>) {
			return ((Map<?, ?>) value).size() == 0;
		} else {
			return value.toString() == null
					|| value.toString().trim().length() == 0;
		}
	}

	public static boolean isFirstName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");

	}
	

	public static boolean isLastName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	public static boolean isBankName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	
	public static boolean isBranchName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	public static boolean isAccountName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	public static boolean isDob(String value) {
		return value.matches("(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}$");
	}

	public static boolean isCompany(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?)*$");
	}

	
	public static boolean isName(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?)*$");
	}
	public static boolean isProductName(String string) {
		return string.matches("(([a-zA-Z]+)|([a-zA-Z][a-zA-Z0-9\\s?]+))$");
	}
	public static Timestamp getDate(){
		java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
		return sqlDate;
	}
	public static boolean isPartNo(String no) {
		return no.matches("[0-9a-zA-Z]*");
	}
	public static boolean isDLNo(String no) {
		return no.matches("[0-9a-zA-Z]*");
	}
	
	public static boolean isAssetSerialNo(String no) {
		return no.matches("[0-9a-zA-Z]*");
	}
	
	public static boolean isStock(String stock) {
		return stock.matches("[0-9]*");
	}
	
	public static boolean isIfsc(String ifscCde) {
		return ifscCde.matches("[A-Z|a-z]{4}[0][\\d]{6}$");
	}
	
	public static boolean isVendorName(String string) {
		return string.matches("([a-zA-Z]+\\s?)*$");
	}
	public static boolean isLanguages(String string) {
		return string.matches("([a-zA-Z,]+\\s?)*$");
	}
	

	public static boolean isSubject(String subject) {
		return subject.matches("[a-zA-Z_-]*");
	}

	public static boolean isNumber(String no) {
		return no.matches("[0-9]*");
	}
	public static boolean isCash(String no) {
		return no.matches("[0-9]*");
	}
	public static boolean isCredit(String no) {
		return no.matches("[0-9]*");
	}
	public static boolean isCheque(String no) {
		return no.matches("[0-9]*");
	}
	public static boolean isPDCheque(String no) {
		return no.matches("[0-9]*");
	}
	public static boolean isDiscount(String no) {
		return no.matches("^\\d+(\\.\\d{1,2})?$");
	}
	public static boolean isShippingCharge(String no) {
		return no.matches("^\\d+(\\.\\d{1,2})?$");
	}
	public static boolean isTax(String no) {
		return no.matches("^\\d+(\\.\\d{1,2})?$");
	}
	public static boolean isOthers(String value) {
		return value.matches("([0-9]+s?)*$");
	}
	public static boolean isAccountNumber(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?)*$");
	}
	public static boolean isTitle(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	public static boolean isRemarks(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?\\,?||\\,\\s?)*$");
	}

	public static boolean isDepartment(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isCity(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isCountry(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isState(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isStreet(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?\\,?||\\,\\s?)*$");
	}

	public static boolean isAddress(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?\\,?||\\,\\s?)*$");
	}
	public static boolean isEducation(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?\\,?||\\,\\s?)*$");
	}
	public static boolean isSkills(String value) {
		return value.matches("([a-zA-Z0-9]+\\s?\\,?||\\,\\s?)*$");
	}
	public static boolean isPhone(String value) {
		return value.matches("[0-9]*");
	}

	public static boolean isMobile(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isGraduatedYear(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isCCA(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isHRA(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isPF(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isYear(String value) {
		return value.matches("[0-9]*");
	}
	
	public static boolean isFax(String value) {
		return value.matches("[0-9]*");
	}

	public static boolean isPostCode(String value) {
		return value.matches("[0-9]*");
	}

	public static boolean isContactId(String value) {
		return value.matches("[0-9]*");
	}

	public static boolean isWebsite(String value) {
		return value
				.matches("^(http[s]?:\\/\\/|(www)?\\.)[a-zA-Z0-9]+\\.(com|in|co.in|org|net|mil|edu|ca|co.uk|co.au|us|co.us|gov)$");
	}

	public static boolean isPostBox(String value) {
		return value.matches("[0-9]*");
	}

	public static boolean isEmail(String value) {
		return value.matches("^([A-Za-z0-9]+((\\.?|\\_?)[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*\\.([A-za-z]{2,4}))");
	}
	
	// Potential Module
	public static boolean isPotentialname(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isAmount(String value) {
		return value.matches("^\\d+(\\.\\d{1,2})?");
	}

	public static boolean isNextstep(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isdescription(String value) {
		return value.matches("([A-Za-z0-9\\s]+)*+([(.?,?)A-Za-z0-9\\s]+)*$");
	}
	// campaign module
	public static boolean isCName(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}
	

	// service module
	public static boolean isservicename(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isnoofunit(String value) {
		return value.matches("[0-9]*");
	}
	public static boolean isRole(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");

	}
	public static boolean isRolename(String value) {
		return value.matches("[a-zA-z]+((\\_?)[a-zA-Z]+)*((\\_?)[a-zA-Z]+)*?$");
	}

	public static boolean islocation(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}

	public static boolean isAccount(String value) {
		return value.matches("([a-zA-Z]+\\s?)*$");
	}


	

	public static boolean isPrice(String string) {
		return string.matches("^\\d+(\\.\\d{1,2})?$");

	}


	
	public static boolean isVatSalesService(String string) {
		return string.matches("^\\d{1,2}(\\.\\d{1,2})?$");
	}
	
	public static boolean isCRate(String string) {
		return string.matches("[0-9]*");

	}

	public static boolean isFilename(String value) {
		return value
				.matches("^[0-9]+:\\s+?(\\S+?)\\s+?([0-9]+?\\s+?\\S+?)\\s+?([0-9]+?)\\s+?(\\S+)$");
	}

	public static boolean isPotentialAmount(String value) {

		return value.matches("[0-9]*");
	}

	public static boolean isSalesStage(String value) {
		return value.matches("[a-zA-Z]*");

	}

	public static boolean isPotentialName(String value) {
		return value.matches("[a-zA-Z]*");
	}

	public static boolean isPotentialDate(String potentialdate) {
		return potentialdate
				.matches("^(0?[1-9]|1[012])[-/]?(0?[1-9]|[12][0-9]|3[01])[-/]?(19[\\d]{2}|20[\\d]{2}|2100)$");
	}
	
	public static boolean isDate(String potentialdate) {
		return potentialdate
				.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
	}
	public static boolean isBody(String body) {
		return body
				.matches("[A-Za-z0-9-]+[0-9A-Za-z#$%=@!{},`~&*()'<>?.:;_|^/-][+\b\t\n\f\r\"\'\\]*");
	}
}
