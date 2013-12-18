/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas
 */
// Command interface, som har en execute metode
public interface Command {

    String execute(HttpServletRequest request);
}
