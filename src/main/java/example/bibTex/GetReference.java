/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.util.ArrayList;

/**
 *
 * @author tiera
 */
public class GetReference {

    public GetReference() {
    }
    public ArrayList<String> referense1(){
        ArrayList<String> r1 = new ArrayList<>();
        r1.add("@article{W04,");
        r1.add("author = {Whittington, Keith J.},");
        r1.add("title = {Infusing active learning into introductory programming courses},");
        r1.add("journal = {J. Comput. Small Coll.},");
        r1.add("volume = {19},");
        r1.add("number = {5},");
        r1.add("year = {2004},");
        r1.add("pages = {249--259},");
        r1.add("publisher = {Consortium for Computing Sciences in Colleges},");
        r1.add("address = {USA},");
        return r1;
    }
    
    public ArrayList<String> referense2(){
        ArrayList<String> r2 = new ArrayList<>();
        r2.add("@article{BB03,");
        r2.add("author = {Bruhn, Russel E. and Burton, Philip J.},");
        r2.add("title = {An approach to teaching Java using computers},");
        r2.add("journal = {SIGCSE Bull.},");
        r2.add("volume = {35},");
        r2.add("number = {4},");
        r2.add("year = {2003},");
        r2.add("pages = {94--99},");
        r2.add("publisher = {ACM},");
        return r2;
    }
}
