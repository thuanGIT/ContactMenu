# DESCRIPTION
*   This project implements a digital contact book.
*   Features:
    *   add: Adding a new contact
    *   edit: Edit an existing contact
    *   remove: Remove an existing contact
    *   count: Return the number of contacts in the book
    *   info: Return full information of a contact



**CRITERIA FOR VALID PHONE NUMBERS:** 

*   The phone number should be split into groups using a space or dash. One group is also possible.
Before the first group, there may or may not be a plus symbol.
*   The first group or the second group can be wrapped in parentheses, 
but there should be no more than one group which is wrapped in parentheses. 
*   There may be no groups wrapped in parentheses.
*   A group can contain numbers, uppercase, and lowercase English letters. 
*   A group should be at least 2 symbols in length. But the first group may be only one symbol in length.

**VALID NUMBERS:**
*   +0 (123) 456-789-ABcd
*   +0 (123) 456
*   (123) 234 345-456
*   1111111111111

**SAMPLE OUTPUT**

*   Add a peson contact
```
Enter action (add, remove, edit, count, info, exit): > add
Enter the type (person, organization): > person
Enter the name: > John
Enter the surname: > Smith
Enter the birth date: >
Bad birth date!
Enter the gender (M, F): >
Bad gender!
Enter the number: > +0 (123) 456-789-ABcd
The record added.
```

*   Add a store contact
```
Enter action (add, remove, edit, count, info, exit): > add
Enter the type (person, organization): > organization
Enter the organization name: > Pizza Shop
Enter the address: > Wall St. 1
Enter the number: > +0 (123) 456-789-9999
The record added.
```
*   Get information of a specific contact
```
Enter action (add, remove, edit, count, info, exit): > info
1. John Smith 
2. Pizza Shop 

Enter index to show info: > 2
Organization name: Pizza shop
Address: Wall St. 1
Number: +0 (123) 456-789-9999
Time created: 2018-01-01T00:00
Time last edit: 2018-01-01T00:00
```
*   Edit an existing contact
```
Enter action (add, remove, edit, count, info, exit): > edit 
1. John Smith
2. Pizza Shop 

Select a record: > 1
Select a field (name, surname, birth, gender, number): > number
Enter number: > (123) 234 345-456
The record updated!
```
*   Exit
```
Enter action (add, remove, edit, count, info, exit): > exit
```