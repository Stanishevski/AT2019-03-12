package by.it.agrinkevich.webcalculator.server;

public class Html {
    static String form =""+
            "<!DOCTYPE html>\n" +
            "<html lang='en'>\n" +
            "<head>\n" +
            "    <meta charset='UTF-8'>\n" +
            "    <title>Title</title>\n" +
            "\n" +
            "    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>\n" +
            "    <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>\n" +
            "    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' crossorigin='anonymous'></script>\n" +
            "    <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class='container'>\n" +
            "    <form class='form-horizontal' method='post'>\n" +
            "        <fieldset>\n" +
            "\n" +
            "            <!-- Form Name -->\n" +
            "            <legend>Calculator</legend>\n" +
            "\n" +
            "            <!-- Text input-->\n" +
            "            <div class='form-group'>\n" +
            "                <label class='col-md-4 control-label' for='expression'>Input expression</label>\n" +
            "                <div class='col-md-4'>\n" +
            "                    <input id='expression' name='expression' type='text' value=\"%s\" class='form-control input-md' required=''>\n" +
            "                    <span class='help-block'>help</span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Button -->\n" +
            "            <div class='form-group'>\n" +
            "                <label class='col-md-4 control-label' for='Submit'></label>\n" +
            "                <div class='col-md-4'>\n" +
            "                    <button id='Submit' name='Submit' class='btn btn-success'>Calc it</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Textarea -->\n" +
            "            <div class='form-group'>\n" +
            "                <label class='col-md-4 control-label' for='results'>Calculate results</label>\n" +
            "                <div class='col-md-4'>\n" +
            "                    <textarea class='form-control' id='results' name='results'>%s</textarea>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "        </fieldset>\n" +
            "    </form>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
