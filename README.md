# Property Management System

## Overview

This project is a Property Management System developed as part of a group assignment. The system is designed to manage various aspects of property management, including resident complaints, facility bookings, payments, visitor entries, and more. The project is implemented in Java using a CLI-based interface.

## Features

- **Resident Management**: Handle resident complaints, invoices, and payments.
- **Facility Management**: Manage facility bookings, payments, and receipts.
- **Visitor Management**: Log visitor entries and issue visitor passes.
- **Security Management**: Record incidents and manage security checkpoints.
- **Employee Management**: Assign jobs and manage employee information.

## File Structure

PropertyManage
├── AdminExComplaint.txt
├── Card.txt
├── Checkpoint.txt
├── Debt.txt
├── Employee.txt
├── Facility.txt
├── FacilityBooking.txt
├── FacilityPaymentHistory.txt
├── FacilityPrice.txt
├── FacilityReceipt.txt
├── Incident.txt
├── OptBgtPlan.txt
├── Patrol.txt
├── Payment.txt
├── PaymentHistory.txt
├── PendingFee.txt
├── ResidentComplaint.txt
├── ResidentInvoiceStatement.txt
├── ResTen.txt
├── ResTenPaymentHistory.txt
├── ResTenPendingFee.txt
├── Unit.txt
├── User.txt
├── VendorComplaint.txt
├── VisitorEntry.txt
├── VisitorPass.txt
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── Data
│ │ │ │ ├── IUser.java
│ │ │ │ ├── Unit.java
│ │ │ │ └── User.java
│ │ │ ├── Handlers
│ │ │ │ ├── CRUD.java
│ │ │ │ └── Utils.java
│ │ │ ├── Main
│ │ │ │ └── MainRun.java
│ │ │ ├── Pages
│ │ │ │ ├── AccountExecMenu.java
│ │ │ │ ├── AdminExComplain.java
│ │ │ │ ├── AdminExecMenu.java
│ │ │ │ ├── AdminFacBooking.java
│ │ │ │ ├── AssignJob.java
│ │ │ │ ├── BExecComplaints.java
│ │ │ │ ├── BuildingExecMenu.java
│ │ │ │ ├── BuildingManagerMenu.java
│ │ │ │ ├── ChargePayment.java
│ │ │ │ ├── ChargePaymentResTen.java
│ │ │ │ ├── EmployeeMgt.java
│ │ │ │ ├── FacilityMenu.java
│ │ │ │ ├── PageUtils.java
│ │ │ │ ├── parkhillinfo1.java
│ │ │ │ ├── ResFacilityBooking.java
│ │ │ │ ├── ResFacilityPayment.java
│ │ │ │ ├── ResidentComplaint.java
│ │ │ │ ├── ResidentMenu.java
│ │ │ │ ├── ResPaymentMenu.java
│ │ │ │ ├── ResTenInvoiceStatement.java
│ │ │ │ ├── ResTenLogin.java
│ │ │ │ ├── ResTenMgt.java
│ │ │ │ ├── ResTenPayment.java
│ │ │ │ ├── ResTenVisitorPass.java
│ │ │ │ ├── ResViewProfile.java
│ │ │ │ ├── SecCheckpoint.java
│ │ │ │ ├── SecIncident.java
│ │ │ │ ├── SecLogin.java
│ │ │ │ ├── Security.java
│ │ │ │ ├── SecurityGuardMenu.java
│ │ │ │ ├── SecurityGuardReport.java
│ │ │ │ ├── SecVisitorEntry.java
│ │ │ │ ├── SecVisitorPass.java
│ │ │ │ ├── TeamStructMgt.java
│ │ │ │ ├── UnitManagement.java
│ │ │ │ ├── UserManagement.java
│ │ │ │ ├── VendorComplaint.java
│ │ │ │ ├── VendorInvoice.java
│ │ │ │ ├── VendorMenu.java
│ │ │ │ ├── VendorPayment.java
│ │ │ │ ├── VendorProfile.java
│ │ │ │ ├── ViewInvoice.java
│ │ │ │ ├── ViewOutStanding.java
│ │ │ │ ├── ViewOutStanding2.java
│ │ │ │ ├── ViewPCJReport.java
│ │ │ │ ├── ViewStruct.java
│ │ │ │ └── VisitorViewPass.java
└── pom.xml


## How to Run

1. **Prerequisites**: Ensure you have Java and Maven installed on your system.
2. **Clone the Repository**: Clone the repository to your local machine using `git clone <repository-url>`.
3. **Navigate to the Project Directory**: Open a terminal and navigate to the project directory.
4. **Build the Project**: Run `mvn clean install` to build the project.
5. **Run the Application**: Execute `mvn exec:java -Dexec.mainClass="Main.MainRun"` to run the application.

## Usage

1. **Login**: The system will prompt you to log in.
2. **Navigate**: Use the menu options to navigate through different functionalities such as managing residents, facilities, visitor entries, etc.
3. **Perform Actions**: Follow the on-screen instructions to perform various actions like booking facilities, logging incidents, handling complaints, etc.

## Contributors

- **Group 32**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
