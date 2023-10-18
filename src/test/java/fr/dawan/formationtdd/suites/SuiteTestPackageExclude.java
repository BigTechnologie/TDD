package fr.dawan.formationtdd.suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("fr.dawan.formationtdd")
// @ExcludePackages permet d'exclure des packages de la sélection
@ExcludePackages({ "fr.dawan.formationtdd.test1", "fr.dawan.formationtdd.test2" })
public class SuiteTestPackageExclude {

}
