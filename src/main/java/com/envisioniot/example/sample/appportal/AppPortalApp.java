/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AppPortalApp
 * Author:   xibin.song
 * Date:     3/7/2022 10:10 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal;

import com.envisioniot.example.sample.appportal.application.*;
import com.envisioniot.example.sample.appportal.asset.*;
import com.envisioniot.example.sample.appportal.auth.*;
import com.envisioniot.example.sample.appportal.userandorg.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class AppPortalApp {
    public void appPortalGeneral(String accessKey, String secretKey, String orgId, String url) {

        /*
        *   1. Login Session
        *   you need to follow this flow to make your own session control
        */

        Login login = new Login();
        String accessToken = login.login(accessKey, secretKey, orgId, url);
        ChooseOrganization chooseOrganization = new ChooseOrganization();
        String refreshToken = chooseOrganization.chooseOrganization(accessKey, secretKey, orgId, url, accessToken);

        // Not for open. This is for testing the max failed login tries.
//        for(int i=0; i<200;i++ ) {
//            try {
//                String accessToken = login.login(accessKey, secretKey, orgId, url);
//            }
//            catch (Exception e){
//
//            }
//        }


//        GetTokenInfomation getTokenInfomation = new GetTokenInfomation();
//        getTokenInfomation.getTokenInfomation(accessKey, secretKey, orgId, url, accessToken);

//        RefreshAccessToken refreshAccessToken = new RefreshAccessToken();
//        String newAccessToken = refreshAccessToken.refreshAccessToken(accessKey, secretKey, orgId, url, refreshToken);

        RevokeRefreshToken revokeRefreshToken = new RevokeRefreshToken();
        revokeRefreshToken.revokeRefreshToken(accessKey, secretKey, orgId, url, accessToken, refreshToken);

//        LogOut logOut = new LogOut();
//        logOut.logout(accessKey, secretKey, orgId, url, newAccessToken);

        /*
        2. User Management
         */
//        CreateAndJoinUser createAndJoinUser = new CreateAndJoinUser();
//        createAndJoinUser.createAndJoinUser(accessKey, secretKey, orgId, url);

        // ????? Error for this. Not tested successfully
//        JoinUsers joinUsers = new JoinUsers();
//        joinUsers.joinUsers(accessKey, secretKey, orgId, url);

//        GetManageableUser getManageableUser = new GetManageableUser();
//        getManageableUser.getManageableUserTest(accessKey, secretKey, orgId, url, accessToken);

//        GetOrganizationList getOrganizationList = new GetOrganizationList();
//        getOrganizationList.getOrganizationList(accessKey, secretKey, orgId, url, accessToken);

        /*      ???   language is not returned.           */
//        GetOrganizationLanguage getOrganizationLanguage = new GetOrganizationLanguage();
//        getOrganizationLanguage.getOrganizationLanguage(accessKey, secretKey, orgId, url, accessToken);

        /* No pagination */
//        GetOrganizationUserList getOrganizationUserList = new GetOrganizationUserList();
//        getOrganizationUserList.getOrganizationUserList(accessKey, secretKey, orgId, url);

//
//        GetOrganizationRoles getOrganizationRoles = new GetOrganizationRoles();
//        getOrganizationRoles.getOrganizationRoles(accessKey, secretKey, orgId, url);

//        GetAppUserList getAppUserList = new GetAppUserList();
//        getAppUserList.getAppUserList(accessKey, secretKey, orgId, url, accessToken);

//        GetUserInformation getUserInformation = new GetUserInformation();
//        getUserInformation.getUserInformation(accessKey, secretKey, orgId, url, accessToken);

//        GetUserDomain getUserDomain = new GetUserDomain();
//        getUserDomain.getUserDomain(accessKey, secretKey, orgId, url);


//        GetUserStructures getUserStructures = new GetUserStructures();
//        getUserStructures.getUserStructures(accessKey, secretKey, orgId, url, accessToken);

//        GetUserRoles getUserRoles = new GetUserRoles();
//        getUserRoles.getUserRoles(accessKey, secretKey, orgId, url);

//        GetUserPermissions getUserPermissions = new GetUserPermissions();
//        getUserPermissions.getUserPermissions(accessKey, secretKey, orgId, url);

//        GetUserBasicInfo getUserBasicInfo = new GetUserBasicInfo();
//        getUserBasicInfo.getUserBasicInfo(accessKey, secretKey, orgId, url);
//        getUserBasicInfo.getUserBasicInfoBaseOnDomain(accessKey, secretKey, orgId, url);
//        getUserBasicInfo.getUserBasicInfoBaseOnPhoneArea(accessKey, secretKey, orgId, url);
//        getUserBasicInfo.getUserBasicInfoBaseOnPhone(accessKey, secretKey, orgId, url);
//        getUserBasicInfo.getUserBasicInfoBaseOnName(accessKey, secretKey, orgId, url);

//        GetUsersAssetList getUsersAssetList = new GetUsersAssetList();
//        getUsersAssetList.getUsersAssetList(accessKey, secretKey, orgId, url);

//        GetUsersRoleList getUserRoleList = new GetUsersRoleList();
//        getUserRoleList.getUsersAssetList(accessKey, secretKey, orgId, url);

//        GetUsersStructureList getUserStructureList = new GetUsersStructureList();
//        getUserStructureList.getUsersStructureList(accessKey, secretKey, orgId, url);

//        GetUsersGroupList getUserGroupList= new GetUsersGroupList();
//        getUserGroupList.getUsersUserGroupList(accessKey, secretKey, orgId, url);

//        AssignOrganizationStructures assignOrganizationStructures = new AssignOrganizationStructures();
//        assignOrganizationStructures.assignOrganizationStructures(accessKey, secretKey, orgId, url);

//        AssignUserRoles assignUserRoles = new AssignUserRoles();
//        assignUserRoles.assignUserRoles(accessKey, secretKey, orgId, url);

//        AssignUserGroups assignUserGroups= new AssignUserGroups();
//        assignUserGroups.assignUserGroups(accessKey, secretKey, orgId, url);

//        RemoveOrganizationStructures removeOrganizationStructures = new RemoveOrganizationStructures();
//        removeOrganizationStructures.removeOrganizationStructures(accessKey, secretKey, orgId, url);

//        RemoveUserRoles removeUserRoles = new RemoveUserRoles();
//        removeUserRoles.removeUserRoles(accessKey, secretKey, orgId, url);

//        RemoveUserGroups removeUserGroups = new RemoveUserGroups();
//        removeUserGroups.removeUserGroups(accessKey, secretKey, orgId, url);

//        RemoveUser removeUser = new RemoveUser();
//        removeUser.removeUser(accessKey, secretKey, orgId, url);

        /*
        3. Asset
         */
//        AuthorizeAsset authorizeAsset = new AuthorizeAsset();
//        authorizeAsset.authorizeAsset(accessKey, secretKey, orgId, url);

//        CheckAssetPermission checkAssetPermission = new CheckAssetPermission();
//        checkAssetPermission.checkAssetPermission(accessKey, secretKey, orgId, url, accessToken);

//        GetAssetsbyApplication getAssetsbyApplication = new GetAssetsbyApplication();
//        getAssetsbyApplication.getAssetsByApplication(accessKey, secretKey, orgId, url, accessToken);

//        GetAssetsbyOrganization getAssetsbyOrganization = new GetAssetsbyOrganization();
//        getAssetsbyOrganization.getAssetsByOrganization(accessKey, secretKey, orgId, url);

//        GetAssetsStructure getAssetsStructure = new GetAssetsStructure();
//        getAssetsStructure.getAssetStructure(accessKey, secretKey, orgId, url, accessToken);

//        GetStructureAsset getStructureAsset = new GetStructureAsset();
//        getStructureAsset.getStructureAsset(accessKey, secretKey, orgId, url, accessToken);

//        SyncAsset syncAsset = new SyncAsset();
//        syncAsset.syncAsset(accessKey, secretKey, orgId, url);

//        GetUserswithAssetAccess getUserswithAssetAccess = new GetUserswithAssetAccess();
//        getUserswithAssetAccess.getPrivilegedUsersToAsset(accessKey, secretKey, orgId, url);

        /*
        4. Application
         */
//        CreateMessage createMessage = new CreateMessage();
//        createMessage.createNormalMessage(accessKey, secretKey, orgId, url);
//        createMessage.createAlertMessage(accessKey, secretKey, orgId, url);

//        UpdateMessage updateMessage = new UpdateMessage();
//        updateMessage.updateAlertMessage(accessKey, secretKey, orgId, url);


//        GetAppMenuAndPermission getAppMenuAndPermission = new GetAppMenuAndPermission();
//        getAppMenuAndPermission.getAppMenuAndPermission(accessKey, secretKey, orgId, url, accessToken);

//        GetColorsOfTheMessageIcon getColorsOfTheMessageIcon = new GetColorsOfTheMessageIcon();
//        getColorsOfTheMessageIcon.getColorsOfTheMessageIcon(accessKey, secretKey, orgId, url);

//        GetMessageRingtones getMessageRingtones = new GetMessageRingtones();
//        getMessageRingtones.getMessageRingtones(accessKey, secretKey, orgId, url);

//        GetUserApplications getUserApplications = new GetUserApplications();
//        getUserApplications.getUserApplications(accessKey, secretKey, orgId, url, accessToken);

//        GetUnresolvedMessages getUnresolvedMessages = new GetUnresolvedMessages();
//        getUnresolvedMessages.getUnresolvedMessages(accessKey, secretKey, orgId, url, accessToken);
    }
}
