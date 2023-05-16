package com.kostkiv.githubusers.data

import com.kostkiv.githubusers.domain.User
import com.kostkiv.githubusers.domain.UserDetailed

class GitHubUsersMapper {

    private fun mapDbModelUserToEntity(userDbModel: UserDbModel): User {
        return User(
            login = userDbModel.login,
            userId = userDbModel.userId,
            avatarUrl = userDbModel.avatarUrl
        )
    }

    fun mapListOfDbModelUsersToEntity(listOfUsers : List<UserDbModel>) : List<User> {
        val domainModelList = mutableListOf<User>()
        listOfUsers.forEach {
            domainModelList.add(mapDbModelUserToEntity(it))
        }
        return domainModelList
    }

    fun mapDbModelUserDetailedToEntity(user : UserDetailedDataModel) : UserDetailed {
        return UserDetailed(
            login = user.login,
            userId = user.userId,
            avatarUrl = user.avatarUrl,
            name = user.name,
            email = user.email,
            organization = user.organization,
            followingCount = user.followingCount,
            followersCount = user.followersCount,
            accountCreated = user.accountCreated
        )
    }
}