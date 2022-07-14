```
               
                                                                                                                            
                                         :8                                
                           .u    .      .88       x.    .        .u    .   
                  u      .d88B :@8c    :888ooo  .@88k  z88u    .d88B :@8c  
               us888u.  ="8888f8888r -*8888888 ~"8888 ^8888   ="8888f8888r 
            .@88 "8888"   4888>'88"    8888      8888  888R     4888>'88"  
            9888  9888    4888> '      8888      8888  888R     4888> '    
            9888  9888    4888>        8888      8888  888R     4888>      
            9888  9888   .d888L .+    .8888Lu=   8888 ,888B .  .d888L .+   
            9888  9888   ^"8888*"     ^%888*    "8888Y 8888"   ^"8888*"    
            "888*""888"     "Y"         'Y"      `Y"   'YP        "Y"      
             ^Y"   ^Y'                                                     
                                                                           
                                                

```
# 1)  Operations on MedicationIntakes

| Operation                  | description                                 |
|----------------------------|---------------------------------------------|
| GET    /intakes/allIntakes 	 | Retrieve all MedicationIntake from the DB.  |
| GET    /intakes/get/{id}   | Retrieve a MdicationIntake.                 |
| PUT    /intakes/put/{id}   | UPDATE  a MdicationIntake DATA /JSON/       |
| POST   /intakes/add 		     | ADD a new MedicationIntake series via JSON. |
| DELETE /intakes/del/{id}   | DELETE a MdicationIntake by ID.             |

# UML
IntelliJ IDEA properties to appear the diagram: <br />
settings / Languages&Frameworks / Markdown / Markdown extensions; check/install Mermaid

```mermaid
classDiagram

MedicationDiary o-- User
MedicationDiary o-- MedicationIntake
MedicationIntake o-- Medicine
MedicationOfWeek o-- MedicationIntake
Envelope .. MedicationOfWeek : sessionStored JSON via frontend
MedicationIntake o-- Time
Time o-- Day

User : Long id
User : String name
User : String passwordSecured

Medicine : Long id
Medicine : String name
Medicine : double mgPerPill

Time : Day day
Time : Hour hour

Day : Date dayOfMonth
Day : String dayOfWeek

MedicationIntake : Long id
MedicationIntake : Time time
MedicationIntake : Medicine medicine
MedicationIntake : double mgPerIntake
MedicationIntake : numberOfPieces()

MedicationOfWeek : Long id
MedicationOfWeek : String year
MedicationOfWeek : String month
MedicationOfWeek : String dayOfMonth
MedicationOfWeek : String dayOfWeek
MedicationOfWeek : List MedicationIntakes
MedicationOfWeek : getMedicineName()
MedicationOfWeek : getMgPerPill()
MedicationOfWeek : getMgPerIntake()
MedicationOfWeek : getPieces()

MedicationDiary : Long id
MedicationDiary : Time time
MedicationDiary : List medicationIntakes


```


       