/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function onlyNumbers(evt)
{
    var e = event || evt;
    var charCode = e.which || e.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return false;
    }

    return true;

}
function onlyLetters(evt)
{
    var e = event || evt;
    var charCode = e.which || e.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return true;
    }

    return false;

}