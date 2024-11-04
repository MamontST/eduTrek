package telran.java53.edutrek.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dao.ContactRepository;
import telran.java53.edutrek.dao.GroupRepository;
import telran.java53.edutrek.dto.GroupDto;
import telran.java53.edutrek.dto.ReminderDto;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

	private final GroupRepository groupRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public GroupDto addGroup(GroupDto groupDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto addReminder(String groupID, ReminderDto reminderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto getGroupById(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupDto> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto updateGroupById(String groupID, GroupDto groupDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto addStudentToGroup(String groupID, List<String> studentsID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto moveStudentToGroup(String studentsID, String groupID, String groupIDNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto archiveGroup(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto removeStudentFromGroup(String studentsID, String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

}
