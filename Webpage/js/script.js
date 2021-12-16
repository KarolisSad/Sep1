var document, DOMParser;
var inputID;
var inputFullName;
var teacherInput = false;
var studentInput = false;
var startDate;
var endDate;




// XMLHttpsRequestStatus
function readXML() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            showData(this);
        }
    };
    xhttp.open("GET", "../sessionList.xml", true);
    xhttp.send();
}



function showData(xml) {
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("sessionList");
    var y = xmlDoc.getElementsByTagName("courseStudentList");
    // since each session has exactly one course - 
    //  and each course has exactly one courseStudentList, we can loop through thoose.
    var listLength = x.length;
    var sessionsImported = 0;

    for (var i = 0; i < listLength; i++) {

        var sessionDate = new Date(x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue, (x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue) - 1, x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue);


        function scheduleTeacher(i) {

            for (var j = 0; j < x[i].getElementsByTagName("teacherList").length; j++ ) {
                if (x[i].getElementsByTagName("teacherId")[0].childNodes[0].nodeValue === inputID) {
                            placeSession(i);
                            sessionsImported++;
                            inputFullName = x[i].getElementsByTagName("teacherName")[0].childNodes[0].nodeValue;
                        }
            }
        }

        function scheduleStudent(i) {
            var numberOfStudents = y[i].getElementsByTagName("studentList").length;
            for (var j = 0; j < (numberOfStudents); j++) {
                if (y[i].getElementsByTagName("studentId")[j].childNodes[0].nodeValue === inputID) {
                    placeSession(i);
                    sessionsImported++;
                    inputFullName = y[i].getElementsByTagName("studentName")[j].childNodes[0].nodeValue;
                }
            }
        }

        function getTeacher(i) {
            var numberofteachers = x[i].getElementsByTagName("teacherList").length;
            if (numberofteachers == 1) {
                return x[i].getElementsByTagName("teacherId")[0].childNodes[0].nodeValue;
            }
            if (numberofteachers == 2) {
                return x[i].getElementsByTagName("teacherId")[0].childNodes[0].nodeValue + "/" + x[i].getElementsByTagName("teacherId")[1].childNodes[0].nodeValue;
            }
        }

        function getStartTime(i) {

            var date = new Date(x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue, x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue,
                x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue,
                x[i].getElementsByTagName("hour")[0].childNodes[0].nodeValue, x[i].getElementsByTagName("minute")[0].childNodes[0].nodeValue, 0, 0);

            return date.getHours() + ":" + date.getMinutes();
        }

        function getEndTime(i) {

            var endTime = new Date(x[i].getElementsByTagName("year")[0].childNodes[0].nodeValue, x[i].getElementsByTagName("month")[0].childNodes[0].nodeValue,
                x[i].getElementsByTagName("day")[0].childNodes[0].nodeValue,
                x[i].getElementsByTagName("hour")[1].childNodes[0].nodeValue, x[i].getElementsByTagName("minute")[1].childNodes[0].nodeValue, 0, 0);
            return endTime.getHours() + ":" + endTime.getMinutes();
        }

        function getDateString(i) {
            return date.getFull() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
        }

        function getDayOfWeek(i) {
            return x[i].getElementsByTagName("dayName")[0].childNodes[0].nodeValue;
        }

        function getRoomNumber(i) {
            return x[i].getElementsByTagName("roomNumber")[0].childNodes[0].nodeValue;
        }

        function getCourse(i) {
            return x[i].getElementsByTagName("courseName")[0].childNodes[0].nodeValue;
        }

        function placeSession(i) {
            switch (getDayOfWeek(i)) {
                case "MONDAY":
                    if (getStartTime(i) == "8:20") { $(".mon1").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "9:10") { $(".mon2").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "10:15") { $(".mon3").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "11:00") { $(".mon4").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "12:45") { $(".mon5").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "13:30") { $(".mon6").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "14:20") { $(".mon7").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }

                case "TUESDAY":
                    if (getStartTime(i) == "8:20") { $(".tue1").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "9:10") { $(".tue2").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "10:15") { $(".tue3").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "11:00") { $(".tue4").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "12:45") { $(".tue5").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "13:30") { $(".tue6").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "14:20") { $(".tue7").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }

                case "WEDNESDAY":
                    if (getStartTime(i) == "8:20") { $(".wed1").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "9:10") { $(".wed2").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "10:15") { $(".wed3").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "11:00") { $(".wed4").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "12:45") { $(".wed5").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "13:30") { $(".wed6").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "14:20") { $(".wed7").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }

                case "THURSDAY":
                    if (getStartTime(i) == "8:20") { $(".thu1").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "9:10") { $(".thu2").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "10:15") { $(".thu3").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "11:00") { $(".thu4").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "12:45") { $(".thu5").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "13:30") { $(".thu6").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "14:20") { $(".thu7").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }

                case "FRIDAY":
                    if (getStartTime(i) == "8:20") { $(".fri1").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "9:10") { $(".fri2").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "10:15") { $(".fri3").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "11:00") { $(".fri4").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "12:45") { $(".fri5").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "13:30") { $(".fri6").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
                    if (getStartTime(i) == "14:20") { $(".fri7").html(getCourse(i) + "   -   " + getTeacher(i) + "   -   " + getRoomNumber(i) + "<br></br>" + getStartTime(i) + "   -   " + getEndTime(i)); break; }
            }
        }

        function isDateInSelection() {
            if (startDate <= sessionDate && sessionDate <= endDate) {
                return true;
            }
            else { return false; }
        }


        if (teacherInput == true && isDateInSelection() == true) {

            scheduleTeacher(i);
        }

        else if (studentInput = true && isDateInSelection() == true) {
            scheduleStudent(i);
        }
    }

    function studentEnd() {
        studentInput = false;
        if (sessionsImported == 0) {
            $(".showCurrentField").text("");
            alert("No sessions for student with ID " + inputID + " found for selected timeframe");
        }
        else {
            $(".showCurrentField").text(inputFullName);
        }
    }

    function teacherEnd() {
        teacherInput = false;
        if (sessionsImported == 0) {

            $(".showCurrentField").text("");
            alert("No sessions for teacher with ID " + inputID + " found for selected timeframe");
        }
        else {
            $(".showCurrentField").text(inputFullName);
        }
    }

    if (teacherInput == true) {
        teacherEnd();
    }

    else if (studentInput = true) {
        studentEnd();
    }

}

$("#teacherModalConfirm").click(function () {
    inputID = $("#teacherIDField").val();
    teacherInput = true;
    $("#teacherIDField").val("");
    clearSchedule();
    readXML();
})

$("#studentModalConfirm").click(function () {
    inputID = $("#studentIDField").val();
    $("#studentIDField").val("");
    studentInput = true;
    clearSchedule();
    readXML();
})


function clearSchedule() {
    $("td").text("");
    $(".showCurrentField").text("");
}


// DatePicker element is from JqueryUI library: https://jqueryui.com/
// Inspired by:
// https://stackoverflow.com/a/42763606


$(".datePicker").datepicker({
    showWeek: true,     //shows week-number
    firstDay: 1,        // makes start-day of week monday
    changeMonth: true,  // enables changing of year and month
    changeYear: true,
    onSelect: function () {
        var date = $(this).datepicker('getDate');       // "holder"-date is set as date clicked on
        startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() + 1 - date.getDay());       //startDate is set to start of week of "holder". (+1 is because javaScript has sunday as first day in week.)
        endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 7);        // endDate is set to be end of week of "holder". (+7 is because javaScript has saturday as alst day of week.)
        $(this).val("Choose Week");     // Default behavior is for the buttontext to display the date chosen - but i wanted the "choose week" - text to stay.
        $(".datesField").text("Showing schedule for: " + startDate.toLocaleDateString() + " - " + endDate.toLocaleDateString());     // outputs 
        clearSchedule();

    }
});




