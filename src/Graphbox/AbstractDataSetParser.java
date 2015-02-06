/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphbox;

import PSPData.DataSet;

/**
 *
 * @author pokotyamu
 */
abstract class AbstractDataSetParser {
    abstract GraphDataSet parse(DataSet ds);
}
