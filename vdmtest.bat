@echo off
rem Tests the date book specification for one test case (argument)
rem -- Output the argument to stdout (for redirect) and "con" (for user feedback)
echo VDM Test: '%1' > con
echo VDM Test: '%1'

rem short names for specification files in Word RTF Format

set S1=Author.rtf
set S2=Interest.rtf
set S3=Affiliation.rtf
set S4=Date.rtf
set S5=Indexer.rtf
set S6=Reference.rtf
set S7=Publication.rtf


set S8=TestAuthor.rtf
set S9=TestIndexer.rtf

rem -- Calls the interpreter for this test case
"C:\Program Files (x86)\The VDM++ Toolbox Academic v8.0\bin\vppde" -i -D -I -P -Q -R vdm.tc -O %1.res %1 %S1% %S2% %S3% %S4% %S5% %S6% %S7% %S8% %S9%

rem -- Check for difference between result of execution and expected result.
if EXIST %1.exp fc /w %1.res %1.exp

:end
