package com.api.utils;

/**
 * 
 * @author Rishasbh Srivastava
 * @Description In this Class We write all the endpoint URL,HTTPS status and
 *              JSON Input and Output Location as well as defined Enum to reuse
 *              in whole framework.
 */
public class GlobalConstant {
	// Read data from framework
	public final static String resource = "src/";
	// Read path of version 3-2-2.1 for input contacts JSON
	public final static String geographysearchV4 = resource + "Version4/inputFiles/Geographies";
	public final static String contactInputV4 = resource + "Version4/inputFiles/contact";
	public final static String contactInputV3 = resource + "Version3/inputFiles/contact";
	public final static String contactInputV2 = resource + "Version2/inputFiles/contact";
	public final static String contactInputV2point1 = resource + "Version2.1/inputFiles/contact";
	// Read path of version 3-2-2.1 for input bounce back
	public final static String bounceBackV3 = resource + "Version3/inputFiles/bounceback";
	public final static String bounceBackV2 = resource + "Version2/inputFiles/bounceback";
	public final static String bounceBackV2point1 = resource + "Version2.1/inputFiles/bounceback";
	// Read path of version 3-2-2.1 for input account JSON
	public final static String accountInputV2point1 = resource + "Version2.1/inputFiles/account";
	public final static String accountInputV3 = resource + "Version3/inputFiles/account";
	public final static String accountInputV4 = resource + "Version4/inputFiles/account";
	// Read path of version 3-2-2.1 for input outlets JSON
	public final static String outletInputV4 = resource + "Version4/inputFiles/outlet";
	public final static String outletInputV3 = resource + "Version3/inputFiles/outlet";
	public final static String outletInputV2 = resource + "Version2/inputFiles/outlet";
	public final static String outletInputV2point1 = resource + "/Version2.1/inputFiles/outlet";
	// Read path of version 3-2-2.1 for output contact JSON
	public final static String contactOutputV4 = resource + "Version4/outputFiles/contact";
	public final static String contactOutputV3 = resource + "Version3/outputFiles/contact";
	public final static String contactOutputV2 = resource + "Version2/outputFiles/contact";
	public final static String contactOutputV2point1 = resource + "/Version2.1/outputFiles/contact";
	// Read path of version 3-2-2.1 for output outlet JSON
	public final static String outletOutputV4 = resource + "Version4/outputFiles/contact";
	public final static String outletOutputV3 = resource + "Version3/outputFiles/contact";
	public final static String outletOutputV2 = resource + "Version2/outputFiles/contact";
	public final static String outletOutputV2point1 = resource + "Version2.1/outputFiles/contact";
	// Read path of version 3-2-2.1 for output outletViews JSON
	public final static String outletViewOutputV3 = resource + "Version3/outputFiles/outletViews";
	public final static String outletViewOutputV2 = resource + "Version2/outputFiles/outletViews";
	public final static String outletViewOutputV2point1 = resource + "Version2.1/outputFiles/outletViews";
	// Read path of version 2 for LookUps JSON
	public final static String lookUpsV2 = resource + "Version2/inputFiles/lookups";

	// Read path of version 3-2-2.1 for targeted list JSON
	public final static String targetedlistInputV4 = resource + "Version4/inputFiles/targetedList";
	public final static String targetedlistInputV3 = resource + "Version3/inputFiles/targetedList";
	public final static String targetedlistOutputV4 = resource + "Version4/outputFiles/targetedList";
	public final static String targetedlistOutputV3 = resource + "Version3/outputFiles/targetedList";
	public final static String targetedlistInputV2point1 = resource + "Version2.1/inputFiles/targetedList";
	public final static String targetedlistOutputV2point1 = resource + "Version2.1/outputFiles/targetedList";
	public final static String targetedlistInputV2 = resource + "Version2/inputFiles/targetedList";
	public final static String targetedlistOutputV2 = resource + "Version2/outputFiles/targetedList";

	// Media Research of version 3-2.2-2
	public final static String AddContactToMRInputV3 = resource + "Version3/inputFiles/MediaResearch";
	public final static String AddContactToMRInputV2point1 = resource + "Version2.1/inputFiles/MediaResearch";
	public final static String AddContactToMRInputV2 = resource + "Version2/inputFiles/MediaResearch";

	// Read path of version 3-2-2.1 for quick search JSON
	public final static String quickSearchInputV4 = resource + "Version4/inputFiles/QuickSearch";
	public final static String quickSearchOutputV4 = resource + "Version4/outputFiles/QuickSearch";
	public final static String quickSearchInputV3 = resource + "Version3/inputFiles/Search";
	public final static String quickSearchOutputV3 = resource + "Version3/outputFiles/quickSearch";
	public final static String quickSearchInputV2point1 = resource + "Version2.1/inputFiles/Search";
	public final static String quickSearchOutputV2point1 = resource + "Version2.1/outputFiles/quickSearch";
	public final static String quickSearchInputV2 = resource + "Version2/inputFiles/Search";
	public final static String quickSearchOutputV2 = resource + "Version2/outputFiles/quickSearch";

	// Http response Code
	public static final int HTTP_OK = 200;
	public static final int HTTP_BAD_REQUEST = 400;
	public static final int HTTP_UNAUTHORIZED = 401;
	public static final int HTTP_INTERNAL_SERVER_ERROR = 500;
	public static final int HTTP_NOT_FOUND = 404;
	public static final int HTTP_FORBIDDEN = 403;
	public static final int HTTP_SERVICE_UNAVAILABLE = 503;
	public static final int NO_CONTENT = 204;

	// Url for Contacts for Version 3
	public final static String QuickSearch4 = "/api/v4/quick-search";
	public final static String outletQuickSearch4 = "/api/v4/quick-search/outlets";
	public final static String contactQuickSearch4 = "/api/v4/quick-search/contacts";
	public final static String contacts4 = "/api/v4/contacts/search";
	public final static String geographysearch4 = "/api/v4/geographies/search";
	public final static String geographyLookup4 = "/api/v4/geographies/lookup";
	public final static String contacts3 = "/api/v3/data/contacts";
	public final static String contactKeywordSearch4 = "/api/v4/contacts/keyword-search";
	public final static String contactKeywordSearch3 = "/api/v3/data/contactKeywordSearch";
	public final static String updatedContacts3 = "/api/v3/data/updatedContacts";
	public final static String removedContacts4 = "/api/v4/contacts/removed-search";
	public final static String removedContacts3 = "/api/v3/data/removedContacts";
	public final static String contactQuickSearch3 = "/api/v3/data/contactQuickSearch";
	public final static String contactViews3 = "/api/v3/data/contactViews";
	public final static String outletViews3 = "/api/v3/data/outletViews";
	public final static String outletsContactsID3 = "/api/v3/data/outletContactIds";
	public final static String contactsToMediaResearch3 = "/api/v3/data/sendContactToMediaResearch";
	public final static String sendContactsBounceBack3 = "/api/v3/data/sendContactBounceBacks";
	public final static String sendOutletsBounceBack3 = "/api/v3/data/sendOutletBounceBacks";

	// Url for Contacts for Version 2.1
	public final static String contacts2point1 = "/api/2.1/data/contacts";
	public final static String contactKeywordSearch2point1 = "/api/2.1/data/contactKeywordSearch";
	public final static String updatedContacts2point1 = "/api/2.1/data/updatedContacts";
	public final static String removedContacts2point1 = "/api/2.1/data/removedContacts";
	public final static String contactQuickSearch2point1 = "/api/2.1/data/contactQuickSearch";
	public final static String contactViews2point1 = "/api/2.1/data/contactViews";
	public final static String outletViews2point1 = "/api/2.1/data/outletViews";
	public final static String outletsContactsID2point1 = "/api/2.1/data/outletContactIds";
	public final static String contactsToMediaResearch2point1 = "/api/2.1/data/sendContactToMediaResearch";
	public final static String sendContactsBounceBack2point1 = "/api/2.1/data/sendContactBounceBacks";
	public final static String sendOutletsBounceBack2point1 = "/api/2.1/data/sendOutletBounceBacks";

	// Url for Contacts for Version 2
	public final static String contacts2 = "/api/v2/agilitydata/contactList";
	public final static String updatedContacts2 = "/api/v2/agilitydata/updatedContactList";
	public final static String removedContacts2 = "/api/v2/agilitydata/removedContactList";
	public final static String contactQuickSearch2 = "/api/v2/agilitydata/contactQuickSearch";
	public final static String contactViews2 = "/api/v2/agilitydata/contactView";
	public final static String outletViews2 = "/api/v2/agilitydata/outletView";
	public final static String outletsContactsID2 = "/api/v2/agilitydata/outletContactIds";
	public final static String contactsToMediaResearch2 = "/api/v2/agilitydata/sendContactToMediaResearch";
	public final static String sendContactsBounceBack2 = "/api/v2/agilitydata/sendContactBounceBacks";
	public final static String sendOutletsBounceBack2 = "/api/v2/agilitydata/sendOutletBounceBacks";

	// Url for Contact Version 2 Depricated
	public final static String contacts2Depricated = "/api/2.1/agilitydata/contactList";
	public final static String updatedContacts2Depricated = "/api/2.1/agilitydata/updatedContactList";
	public final static String removedContacts2Depricated = "/api/2.1/agilitydata/removedContactList";
	public final static String contactQuickSearch2Depricated = "/api/2.1/agilitydata/contactQuickSearch";
	public final static String contactViews2Depricated = "/api/2.1/agilitydata/contactView";
	public final static String outletViews2Depricated = "/api/2.1/agilitydata/outletView";
	public final static String outletsContactsID2Depricated = "/api/2.1/agilitydata/outletContactIds";
	public final static String contactsToMediaResearch2Depricated = "/api/2.1/agilitydata/sendContactToMediaResearch";
	public final static String sendContactsBounceBack2Depricated = "/api/2.1/agilitydata/sendContactBounceBacks";
	public final static String sendOutletsBounceBack2Depricated = "/api/2.1/agilitydata/sendOutletBounceBacks";
	public final static String outlets2Depricated = "/api/2.1/agilitydata/outletList";
	public final static String updatedOutlets2Depricated = "/api/2.1/agilitydata/updatedOutletList";
	public final static String removedOutlets2Depricated = "/api/2.1/agilitydata/removedOutletList";
	public final static String outletsIds2Depricated = "/api/2.1/agilitydata/outletIdList";
	public final static String outletContactIds2Depricated = "/api/2.1/agilitydata/outletContactIdList";
	public final static String outletQuickSearch2Depricated = "/api/2.1/agilitydata/outletQuickSearch";

	// Url for Lookups for Version 3
	public final static String subjectsLookup3 = "/api/v3/data/subjectLookup";
	public final static String relatedSubjectsLookups3 = "/api/v3/data/relatedSubjectLookup";
	public final static String geographyLookups3 = "/api/v3/data/geographyLookup";
	public final static String jobRoleLookups3 = "/api/v3/data/jobRoleLookup";
	public final static String languageLookups3 = "/api/v3/data/languageLookup";
	public final static String outletTypesLookups3 = "/api/v3/data/outletTypeLookup";
	public final static String frequencyLookups3 = "/api/v3/data/frequencyLookup";
	public final static String mediaTypeLookups3 = "/api/v3/data/mediaTypeLookup";
	public final static String newsFocusLookups3 = "/api/v3/data/newsFocusLookup";

	// Url for Lookups for Version 2.1
	public final static String subjectsLookup2point1 = "/api/2.1/data/subjectLookup";
	public final static String relatedSubjectsLookups2point1 = "/api/2.1/data/relatedSubjectLookup";
	public final static String geographyLookups2point1 = "/api/2.1/data/geographyLookup";
	public final static String jobRoleLookups2point1 = "/api/2.1/data/jobRoleLookup";
	public final static String languageLookups2point1 = "/api/2.1/data/languageLookup";
	public final static String outletTypesLookups2point1 = "/api/2.1/data/outletTypeLookup";
	public final static String frequencyLookups2point1 = "/api/2.1/data/frequencyLookup";
	public final static String mediaTypeLookups2point1 = "/api/2.1/data/mediaTypeLookup";
	public final static String newsFocusLookups2point1 = "/api/2.1/data/newsFocusLookup";

	// Url for Lookups for Version 2
	public final static String subjectsLookup2 = "/api/v2/data/subjectLookup";
	public final static String relatedSubjectsLookups2 = "/api/v2/data/relatedSubjectLookup";
	public final static String geographyLookups2 = "/api/v2/data/geographyLookup";
	public final static String jobRoleLookups2 = "/api/v2/data/jobRoleLookup";
	public final static String languageLookups2 = "/api/v2/data/languageLookup";
	public final static String outletTypesLookups2 = "/api/v2/data/outletTypeLookup";
	public final static String frequencyLookups2 = "/api/v2/data/frequencyLookup";
	public final static String mediaTypeLookups2 = "/api/v2/data/mediaTypeLookup";
	public final static String newsFocusLookups2 = "/api/v2/data/newsFocusLookup";

	public final static String outletIDs = "api/v3/data/outletIds";
	// Url for Outlets for Version 3
	public final static String outlets4 = "/api/v4/outlets/search";
	public final static String outlets3 = "/api/v3/data/outlets";
	public final static String updatedOutlets3 = "/api/v3/data/updatedOutlets";
	public final static String removedOutlets4 = "/api/v4/outlets/removed-search";
	public final static String removedOutlets3 = "/api/v3/data/removedOutlets";
	public final static String outletsIds3 = "/api/v3/data/outletIds";
	public final static String outletContactIds3 = "/api/v3/data/outletContactIds";
	public final static String outletQuickSearch3 = "/api/v3/data/outletQuickSearch";
	// Url for Outlets for Version 2.1
	public final static String outlets2point1 = "/api/2.1/data/outlets";
	public final static String updatedOutlets2point1 = "/api/2.1/data/updatedOutlets";
	public final static String removedOutlets2point1 = "/api/2.1/data/removedOutlets";
	public final static String outletsIds2point1 = "/api/2.1/data/outletIds";
	public final static String outletContactIds2point1 = "/api/2.1/data/outletContactIds";
	public final static String outletQuickSearch2point1 = "/api/2.1/data/outletQuickSearch";
	// Url for Outlets for Version 2
	public final static String outlets2 = "/api/v2/agilitydata/outletList";
	public final static String updatedOutlets2 = "/api/v2/agilitydata/updatedOutletList";
	public final static String removedOutlets2 = "/api/v2/agilitydata/removedOutletList";
	public final static String outletsIds2 = "/api/v2/agilitydata/outletIdList";
	public final static String outletContactIds2 = "/api/v2/agilitydata/outletContactIdList";
	public final static String outletQuickSearch2 = "/api/v2/agilitydata/outletQuickSearch";
	// Url for Outlets for Version 3
	public final static String targetedList4 = "/api/v4/targeted-lists";
	public final static String targetedList3 = "/api/v3/manage/targetedLists";
	public final static String targetedList2point1 = "/api/2.1/manage/targetedLists";
	public final static String targetedList2 = "/api/v2/agilitydata/targetedLists";
	// Url for Media research contact
	public final static String AddContactToMR3 = "/api/v3/data/sendContactToMediaResearch";
	public final static String AddContactToMR2point1 = "/api/2.1/data/sendContactToMediaResearch";
	public final static String AddContactToMR2 = "/api/v2/agilitydata/sendContactToMediaResearch";
	public final static String AddContactToMR2Depricated = "/api/2.1/agilitydata/sendContactToMediaResearch";
	// Url for Media research outlet
	public final static String AddOutletToMR3 = "/api/v3/data/sendOutletToMediaResearch";
	public final static String AddOutletToMR2point1 = "/api/2.1/data/sendOutletToMediaResearch";
	public final static String AddOutletToMR2 = "/api/v2/agilitydata/sendOutletToMediaResearch";
	public final static String AddOutletToMR2Depricated = "/api/2.1/agilitydata/sendOutletToMediaResearch";
	// Url for Quick Search
	public final static String quickSearch3 = "/api/v3/data/quickSearch";
	public final static String quickSearch2point1 = "/api/2.1/data/quickSearch";
	public final static String quickSearch2 = "/api/v2/agilitydata/quickSearch";
	public final static String quickSearch2Depricated = "/api/2.1/agilitydata/quickSearch";
	// Url for Account Management Version 2
	public final static String validateClient2 = "/api/v2/agilitydata/validateClient";
	// Url for Account Management Version 2.1
	public final static String validateClient2point1 = "/api/2.1/account/validate";
	public final static String getDisclaimerID2point1 = "/api/2.1/account/getDisclaimer";
	public final static String createAccountID2point1 = "/api/2.1/account/createAccount";
	public final static String updateAccountID2point1 = "/api/2.1/account/updateAccount";
	public final static String createUserID2point1 = "/api/2.1/account/createUser";
	public final static String updateUserID2point1 = "/api/2.1/account/updateUser";
	public final static String deactivateUserID2point1 = "/api/2.1/account/deactivateUser";
	public final static String activateUserID2point1 = "/api/2.1/account/activateUser";
	public final static String swapUserID2point1 = "/api/2.1/account/swapUser";
	public final static String partnerResellerUserID2point1 = "/api/2.1/account/partnerResellerView";
	public final static String accountViewsID2point1 = "/api/2.1/account/accountViews";
	public final static String userViewsID2point1 = "/api/2.1/account/userViews";
	// Url for Account Management Version 3
	public final static String validateClient4 = "/api/v4/authorizations/validation";
	public final static String validateClient3 = "/api/v3/account/validate";
	public final static String getDisclaimerID4 = "/api/v4/authorizations/disclaimer";
	public final static String getDisclaimerID3 = "/api/v3/account/getDisclaimer";
	public final static String createAccountID4 = "/api/v4/accounts";
	public final static String createAccountID3 = "/api/v3/account/createAccount";
	public final static String updateAccountID3 = "/api/v3/account/updateAccount";
	public final static String createUserID4 = "/api/v4/users";
	public final static String createUserID3 = "/api/v3/account/createUser";
	public final static String updateUserID4 = "/api/v4/users/";
	public final static String updateUserID3 = "/api/v3/account/updateUser";
	public final static String deactivateUserID4 = "/api/v4/users/";
	public final static String deactivateUserID3 = "/api/v3/account/deactivateUser";
	public final static String activateUserID3 = "/api/v3/account/activateUser";
	public final static String swapUserID3 = "/api/v3/account/swapUser";
	public final static String partnerResellerUserID3 = "/api/v3/account/partnerResellerView";
	public final static String accountViewsID3 = "/api/v3/account/accountViews";
	public final static String userViewsID4 = "/api/v4/users/";
	public final static String userViewsID3 = "/api/v3/account/userViews";
	// Url for target Version 3-2.1-2
	public final static String targetedIndex4 = "/api/v4/targeted-lists";
	public final static String targetedIndex3 = "/api/v3/manage/targetedLists";
	public final static String targetedIndex2point1 = "/api/2.1/manage/targetedLists";
	public final static String targetedIndex2 = "/api/v2/agilitydata/targetedLists";
	public final static String targetedIndex2Depricated = "/api/2.1/agilitydata/targetedLists";
	public final static String targetedSummary4 = "/api/v4/targeted-lists/";
	public final static String targetedSummary3 = "/api/v3/manage/targetedLists/summary";
	public final static String targetedSummary2point1 = "/api/2.1/manage/targetedLists/summary";
	public final static String targetedSummary2 = "/api/v2/agilitydata/targetedLists/summary";
	public final static String targetedListContact4 = "/api/v4/targeted-lists/";
	public final static String targetedListContact3 = "/api/v3/manage/targetedLists/list";
	public final static String targetedListContact2point1 = "/api/2.1/manage/targetedLists/list";
	public final static String targetedListContact2 = "/api/v2/agilitydata/targetedLists/list";
	public final static String targetedListContact2Depricated = "/api/2.1/agilitydata/targetedLists/list";
	public final static String targetedListUpdate4 = "/api/v4/targeted-lists/";
	public final static String targetedListUpdate3 = "/api/v3/manage/targetedLists";
	public final static String targetedListUpdate2point1 = "/api/2.1/manage/targetedLists";
	public final static String targetedListUpdate2 = "/api/v2/agilitydata/targetedLists";
	public final static String AddContactTotargetedList4 = "/api/v4/targeted-lists/";
	public final static String AddContactTotargetedList3 = "/api/v3/manage/targetedLists/list";
	public final static String AddContactTotargetedList2point1 = "/api/2.1/manage/targetedLists/list";
	public final static String AddContactTotargetedList2 = "/api/v2/agilitydata/targetedLists/list";
	public final static String RemoveContactTotargetedList4 = "/api/v4/targeted-lists/";
	public final static String RemoveContactTotargetedList3 = "/api/v3/manage/targetedLists/list";
	public final static String RemoveContactTotargetedList2point1 = "/api/2.1/manage/targetedLists/list";
	public final static String RemoveContactTotargetedList2 = "/api/v2/agilitydata/targetedLists/list";
	public final static String DeletetargetedList4 = "/api/v4/targeted-lists/";
	public final static String DeletetargetedList3 = "/api/v3/manage/targetedLists";
	public final static String DeletetargetedList2point1 = "/api/2.1/manage/targetedLists";
	public final static String DeletetargetedList2 = "/api/v2/agilitydata/targetedLists";

	// Depricated End Point for Version 2
	public final static String validateClient2Depricated = "/api/2.1/account/validate";

	// File Name Enum
	public enum FileName {

		Contact("contact"), geographySearch("geographiesSearch"), geographyLookup("geographyLookup"),
		UpdatedContacts("updatedContacts"), UpdatedOutlets("updatedOutlets"), RemovedContacts("removedContacts"),
		RemovedOutlets("removedOutlets"), OutletIds("outletids"), outlets("Outlets"),
		outletContactIds("outletContactIds"), contactViews("contactView"),
		LookupsWithSingleParameter("LookupsWithSingleParameter"), LookupsWithTwoParameter("LookupsWithTwoParameter"),
		outletViews("outletView"), CreateAccount("createAccount"), UpdateAccount("updateAccount"),
		CreateUser("createUser"), UpdateUser("updateUser"), DeactivateUser("deactivateUser"),
		ActivateUser("activateUser"), SwapUser("swapUser"), AccountViews("accountViews"), UserViews("userViews"),
		Outlet("outlet"), ContactKeywordSearch("contactKeywordSearch"), outletQuickSearch("outletquicksearch"),
		contactQuickSearch("contactQuickSearch"), contactbounceback("contactbounceback"),
		outletbounceback("outletbounceback"), updateAccountgeography("updateAccountgeography");

		private String value;

		private FileName(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	public enum JsonProperties {

		ApiContactIds("apiContactIds"), ApiOutletContactIds("apiOutletContactIds"), Names("names"),
		SubjectSearch("subjectSearch"), WritingAbout("writingAbout"), JobRoles("jobRoles"), Group("group"),
		MediaTypes("mediaTypes"), OutletSubjectSearch("outletSubjectSearch"),
		TwitterHandleRequired("twitterHandleRequired"), LinkedinProfileRequired("linkedinProfileRequired"),
		PrimaryContactsOnly("primaryContactsOnly"), SmartSort("smartSort"), SortBy("sortBy"), Order("order");

		private String value;

		private JsonProperties(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

}
