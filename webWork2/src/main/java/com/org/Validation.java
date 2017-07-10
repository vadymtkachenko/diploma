package com.org;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Elat on 22.04.2017.
 */
public class Validation {

    private String message;
    private String empName;
    private String empSurname;
    private String withGuest;
    private String number;
    private String typeRoom;
    private String stageRoom;
    private String priceRoom;
    private String depName;
    private String depNumber;
    private String nameValid = "[A-Z][a-zA-Z]{1,19} *";
    private String priceValid = "^[0-9]+(\\.[0-9]+)?$";
    private String dateValid = "^\\d{4}-\\d{2}-\\d{2}$";
    private String emailValid = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private String numberValid = "[0-9]{10} *";
    private String stageValid = "[0-9]*";

    public boolean validateClient(HttpServletRequest request, String name, String surname, String with, String telephoneNumber) {
        if (name.length() == 0 || !name.matches(nameValid) || surname.length() == 0 || !surname.matches(nameValid) ||
                with.length() == 0 || !with.matches(nameValid) ||
                telephoneNumber.length() == 0 || !telephoneNumber.matches(numberValid)) {
            if (name.length() == 0 && surname.length() == 0 && with.length() == 0 && telephoneNumber.length() == 0) {
                message = "All is null!";
                request.setAttribute("message", message);
            }
//                CHECKING FOR VALID
            if (!name.matches(nameValid)) {
                empName = "Name is incorrect. Name must start with big letter and contain maximum 20 characters!";
                request.setAttribute("empName", empName);
            }
            if (!surname.matches(nameValid)) {
                empSurname = "Surname is incorrect! Surname must start with big letter and contain maximum 20 characters!";
                request.setAttribute("empSurname", empSurname);
            }
            if (!with.matches(nameValid)) {
                withGuest = "With is incorrect! With must start with big letter and contain maximum 20 characters!";
                request.setAttribute("withGuest", withGuest);
            }
            if (!telephoneNumber.matches(numberValid)) {
                number = "Number is incorrect! Number must contain 10 digits!";
                request.setAttribute("number", number);
            }
//               CHECKING FOR NULLS
            if (name.length() == 0) {
                empName = "Name can not be null!";
                request.setAttribute("empName", empName);
            }
            if (surname.length() == 0) {
                empSurname = "Surname can not be null!";
                request.setAttribute("empSurname", empSurname);
            }
            if (with.length() == 0) {
                withGuest = "With can not be null!";
                request.setAttribute("with", withGuest);
            }
            if (telephoneNumber.length() == 0) {
                number = "Number can not be null!";
                request.setAttribute("number", number);
            }
            return true;
        } else return false;
    }

    public boolean validateRoom(HttpServletRequest request, String type, String price, String stage, String number) {
        if (type.length() == 0 || !type.matches(nameValid) || price.length() == 0 || !price.matches(priceValid) ||
                stage.length() == 0 || !stage.matches(stageValid) ||
                number.length() == 0 || !number.matches(numberValid)) {
            if (type.length() == 0 && price.length() == 0 && stage.length() == 0 && number.length() == 0) {
                message = "All is null!";
                request.setAttribute("message", message);
            }
//                CHECKING FOR VALID
            if (!type.matches(nameValid)) {
                typeRoom = "Room Type is incorrect. Room Type must start with big letter and contain maximum 20 characters!";
                request.setAttribute("typeRoom", typeRoom);
            }
            if (!price.matches(priceValid)) {
                priceRoom = "Price is incorrect! Price must be NN.NN!";
                request.setAttribute("priceRoom", priceRoom);
            }
            if (!stage.matches(stageValid)) {
                stageRoom = "Stage of Room is incorrect! Stage of Room must contain 1 digit!";
                request.setAttribute("stageRoom", stageRoom);
            }
            if (!number.matches(numberValid)) {
                number = "Number is incorrect! Number must contain 10 digits!";
                request.setAttribute("number", number);
            }
//               CHECKING FOR NULLS
            if (type.length() == 0) {
                typeRoom = "Type can not be null!";
                request.setAttribute("typeRoom", typeRoom);
            }
            if (price.length() == 0) {
                priceRoom = "Price can not be null!";
                request.setAttribute("priceRoom", priceRoom);
            }
            if (stage.length() == 0) {
                stageRoom = "StageRoom can not be null!";
                request.setAttribute("stageRoom", stageRoom);
            }
            if (number.length() == 0) {
                number = "Number can not be null!";
                request.setAttribute("number", number);
            }
            return true;
        } else return false;
    }

//    public boolean validateEmployeeEdit(HttpServletRequest request, String name, String surname, String email, String date, String depid) {
//
//        if (name.length() == 0 || !name.matches(nameValid) || surname.length() == 0 || !surname.matches(nameValid) ||
//                email.length() == 0 || !email.matches(emailValid) ||
//                date.length() == 0 || !date.matches(dateValid) || depid.length() == 0 || !depid.matches(numberValid)) {
//            if (name.length() == 0 && surname.length() == 0 && email.length() == 0 && date.length() == 0 && depid.length() == 0) {
//                message = "All is null!";
//                request.setAttribute("message", message);
//            }
////                CHECKING FOR VALID
//            if (!name.matches(nameValid)) {
//                empName = "Name is incorrect. Name must start with big letter and consist maximum 20 characters!";
//                request.setAttribute("empName", empName);
//            }
//            if (!surname.matches(nameValid)) {
//                empSurname = "Surname is incorrect! Surname must start with big letter and consist maximum 20 characters!";
//                request.setAttribute("empSurname", empSurname);
//            }
//            if (!email.matches(emailValid)) {
//                with = "Email is incorrect!";
//                request.setAttribute("with", with);
//            }
//            if (!date.matches(dateValid)) {
//                number = "Date is incorrect!";
//                request.setAttribute("number", number);
//            }
//            if (!depid.matches(numberValid)) {
//                empId = "Id of department is incorrect!";
//                request.setAttribute("empId", empId);
//            }
////               CHECKING FOR NULLS
//            if (name.length() == 0) {
//                empName = "Name can not be null!";
//                request.setAttribute("empName", empName);
//            }
//            if (surname.length() == 0) {
//                empSurname = "Surname can not be null!";
//                request.setAttribute("empSurname", empSurname);
//            }
//            if (email.length() == 0) {
//                with = "Email can not be null!";
//                request.setAttribute("with", with);
//            }
//            if (date.length() == 0) {
//                number = "Date can not be null!";
//                request.setAttribute("number", number);
//            }
//            if (depid.length() == 0) {
//                empId = "Id of department can not be null!";
//                request.setAttribute("empId", empId);
//            }
//            return true;
//        } else return false;
//    }

    public boolean validateDepartment(HttpServletRequest request, String name, String number) {
        if (name.length() == 0 || !name.matches(nameValid)
                || number.length() == 0 ||
                number.equals("0") ||
                !number.matches(numberValid)) {
            if (name.length() == 0 && (number.length() == 0 || number.equals("0"))) {
//                CHECKING FOR NULLS
                message = "All is null!";
                request.setAttribute("message", message);
            }
            if (number.length() == 0 || number.equals("0")) {
                depNumber = "Number can not be null!";
                request.setAttribute("depNumber", depNumber);
            }
            if (name.length() == 0) {
                depName = "Name can not be null";
                request.setAttribute("depName", depName);
            }
//            CHECKING FOR VALID
            if (!name.matches(nameValid)) {
                depName = "Name is incorrect. Name must start with big letter and contain maximum 20 characters!";
                request.setAttribute("depName", depName);
            }
            if (!number.matches(numberValid)) {
                depNumber = "Number is incorrect! Number must contain maximum 6 digits!";
                request.setAttribute("depNumber", depNumber);
            }

            return true;
        } else return false;
    }
}

