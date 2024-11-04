package telran.java53.edutrek.service;

import java.util.List;

import telran.java53.edutrek.dto.GroupDto;
import telran.java53.edutrek.dto.ReminderDto;

public interface GroupService {
	GroupDto addGroup(GroupDto groupDto);

	GroupDto addReminder(String groupID, ReminderDto reminderDto);

	GroupDto getGroupById(String groupID);

	List<GroupDto> getAllGroups();

	GroupDto updateGroupById(String groupID, GroupDto groupDto);

	GroupDto addStudentToGroup(String groupID, List<String> studentsID);

	GroupDto moveStudentToGroup(String studentsID, String groupID, String groupIDNew);

	GroupDto archiveGroup(String groupID);

	GroupDto removeStudentFromGroup(String studentsID, String groupID);

}
