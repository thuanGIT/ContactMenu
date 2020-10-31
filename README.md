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

**SAMPLE OUTPUT**<br/>
Enter action (add, remove, edit, count, info, exit): > add<br/>
Enter the type (person, organization): > person<br/>
Enter the name: > John<br/>
Enter the surname: > Smith<br/>
Enter the birth date: ><br/>
Bad birth date!<br/>
Enter the gender (M, F): ><br/>
Bad gender!<br/>
Enter the number: > +0 (123) 456-789-ABcd<br/>
The record added.<br/>

Enter action (add, remove, edit, count, info, exit): > add<br/>
Enter the type (person, organization): > organization<br/>
Enter the organization name: > Pizza Shop<br/>
Enter the address: > Wall St. 1<br/>
Enter the number: > +0 (123) 456-789-9999<br/>
The record added.<br/>

Enter action (add, remove, edit, count, info, exit): > info<br/>
1. John Smith <br/>
2. Pizza Shop <br/>

Enter index to show info: > 2<br/>
Organization name: Pizza shop<br/>
Address: Wall St. 1<br/>
Number: +0 (123) 456-789-9999<br/>
Time created: 2018-01-01T00:00<br/>
Time last edit: 2018-01-01T00:00<br/>

Enter action (add, remove, edit, count, info, exit): > edit <br/>
1. John Smith<br/>
2. Pizza Shop <br/>

Select a record: > 1<br/>
Select a field (name, surname, birth, gender, number): > number<br/>
Enter number: > (123) 234 345-456<br/>
The record updated!<br/>

Enter action (add, remove, edit, count, info, exit): > info<br/>
1. John Smith<br/>
2. Pizza Shop <br/>

Select a record: > 1<br/>
Name: John<br/>
Surname: Smith<br/>
Birth date: [no data]<br/>
Gender: [no data]<br/>
Number: (123) 234 345-456<br/>
Time created: 2018-01-01T00:00<br/>
Time last edit: 2018-01-01T00:01<br/>

Enter action (add, remove, edit, count, info, exit): > exit
