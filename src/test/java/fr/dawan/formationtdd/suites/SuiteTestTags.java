package fr.dawan.formationtdd.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
// @SuiteDisplayName -> pour renommer la suite de test
@SuiteDisplayName("Les cas de test qui correspondent à de collections")
@SelectPackages("fr.dawan.formationtdd")
// @IncludeTags -> On inclut tous les méthodes qui correspond aux nom du tag
@IncludeTags("COLLECTION")
public class SuiteTestTags {

}
